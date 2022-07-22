package com.storeparser.microservice.componentservice.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import com.storeparser.microservice.componentservice.entity.Store;
import com.storeparser.microservice.componentservice.repository.GraphicsCardPriceRepository;
import com.storeparser.microservice.componentservice.repository.GraphicsCardRepository;
import com.storeparser.microservice.componentservice.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class KafkaListeners {

    @Autowired
    private GraphicsCardPriceRepository priceRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private GraphicsCardRepository graphicsCardRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic-name.graphics-card}" , groupId = "groupId")
    public void listenGraphicsCard(@Payload String data) throws JsonProcessingException {
        GraphicsCard graphicsCard = objectMapper.readValue(data, GraphicsCard.class);

        System.out.println("Received: " + data);
        System.out.println("Object: " + graphicsCard);

        String storeShortName = graphicsCard.getStoreShortName();
        Optional<Store> storeOptional = storeRepository.findByShortName(storeShortName);
        Store store;
        if (storeOptional.isEmpty()) {
            store = new Store();
            store.setShortName(storeShortName);
            store.setDisplayName(graphicsCard.getStoreDisplayName());
            storeRepository.save(store);
        } else {
            store = storeOptional.get();
        }
        graphicsCardRepository.save(graphicsCard);

        GraphicsCardPrice cardPrice = new GraphicsCardPrice();
        cardPrice.setPrice(graphicsCard.getPrice());
        cardPrice.setStoreId(store.getId());
        cardPrice.setStock(graphicsCard.getStock());
        cardPrice.setTimestamp(LocalDateTime.now());
        cardPrice.setGraphicsCardId(graphicsCard.getId());
        priceRepository.save(cardPrice);
    }
}
