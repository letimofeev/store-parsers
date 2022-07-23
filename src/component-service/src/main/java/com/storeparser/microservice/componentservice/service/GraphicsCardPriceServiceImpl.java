package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import com.storeparser.microservice.componentservice.entity.Store;
import com.storeparser.microservice.componentservice.repository.GraphicsCardPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GraphicsCardPriceServiceImpl implements GraphicsCardPriceService {

    @Autowired
    private GraphicsCardPriceRepository priceRepository;

    @Override
    public GraphicsCardPrice saveFromStoreAndGraphicsCard(Store store, GraphicsCard graphicsCard) {
        GraphicsCardPrice cardPrice = new GraphicsCardPrice();
        cardPrice.setStoreId(store.getId());
        cardPrice.setGraphicsCardId(graphicsCard.getId());
        cardPrice.setPrice(graphicsCard.getPrice());
        cardPrice.setStock(graphicsCard.getStock());
        cardPrice.setUrl(graphicsCard.getUrl());
        cardPrice.setTimestamp(LocalDateTime.now());
        priceRepository.save(cardPrice);
        return cardPrice;
    }
}
