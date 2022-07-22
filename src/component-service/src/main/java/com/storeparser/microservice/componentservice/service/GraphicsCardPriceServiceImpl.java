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
        cardPrice.setPrice(graphicsCard.getPrice());
        cardPrice.setStoreId(store.getId());
        cardPrice.setStock(graphicsCard.getStock());
        cardPrice.setTimestamp(LocalDateTime.now());
        cardPrice.setGraphicsCardId(graphicsCard.getId());
        priceRepository.save(cardPrice);
        return cardPrice;
    }
}
