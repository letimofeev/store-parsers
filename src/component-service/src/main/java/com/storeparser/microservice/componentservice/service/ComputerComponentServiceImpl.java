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
    private BrandService brandService;

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
        Brand brand = new Brand(graphicsCardRaw.getBrandName());
        Store store = new Store(graphicsCardRaw.getStoreDisplayName());
        brandService.save(brand);
        graphicsCard.setBrand(brand);
        storeService.save(store);
        cardService.save(graphicsCard);
        GraphicsCardPrice cardPrice = new GraphicsCardPrice(store,
                graphicsCard.getId(),
                graphicsCardRaw.getPrice(),
                graphicsCardRaw.getUrl(),
                graphicsCardRaw.getStock());
        cardPriceService.save(cardPrice);
        return graphicsCard;
    }
}
