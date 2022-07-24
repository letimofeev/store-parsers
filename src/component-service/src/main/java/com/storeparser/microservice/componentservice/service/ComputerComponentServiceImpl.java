package com.storeparser.microservice.componentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.componentservice.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerComponentServiceImpl implements ComputerComponentService {

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
    public GraphicsCard saveGraphicsCardWithDependent(String graphicsCardRawJson)
            throws JsonProcessingException {
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
    }
}
