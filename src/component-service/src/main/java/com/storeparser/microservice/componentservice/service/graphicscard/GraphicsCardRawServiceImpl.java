package com.storeparser.microservice.componentservice.service.graphicscard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.componentservice.entity.*;
import com.storeparser.microservice.componentservice.service.StoreService;
import com.storeparser.microservice.componentservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GraphicsCardRawServiceImpl implements GraphicsCardRawService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StoreService storeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private GraphicsCardService cardService;

    @Autowired
    private GraphicsCardPriceService cardPriceService;

    @Override
    public GraphicsCard saveWithDependencies(String graphicsCardRawJson) {
        try {
            GraphicsCardRaw graphicsCardRaw = objectMapper.readValue(graphicsCardRawJson,
                    GraphicsCardRaw.class);
            GraphicsCard graphicsCard = objectMapper.readValue(graphicsCardRawJson,
                    GraphicsCard.class);
            Vendor vendor = new Vendor(graphicsCardRaw.getVendorName());
            Store store = new Store(graphicsCardRaw.getStoreDisplayName());
            vendorService.save(vendor);
            graphicsCard.setVendor(vendor);
            storeService.save(store);
            cardService.save(graphicsCard);
            GraphicsCardPrice cardPrice = new GraphicsCardPrice(store,
                    graphicsCard.getId(),
                    graphicsCardRaw.getPrice(),
                    graphicsCardRaw.getUrl(),
                    graphicsCardRaw.isStock());
            cardPriceService.save(cardPrice);
            return graphicsCard;
        } catch (JsonProcessingException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public GraphicsCard saveWithDependencies(GraphicsCardRaw graphicsCardRaw) {
        try {
            String json = objectMapper.writeValueAsString(graphicsCardRaw);
            return saveWithDependencies(json);
        } catch (JsonProcessingException e) {
            throw new JsonParseException(e);
        }
    }
}
