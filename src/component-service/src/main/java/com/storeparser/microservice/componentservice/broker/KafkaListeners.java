package com.storeparser.microservice.componentservice.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.Store;
import com.storeparser.microservice.componentservice.service.GraphicsCardPriceService;
import com.storeparser.microservice.componentservice.service.GraphicsCardService;
import com.storeparser.microservice.componentservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    private GraphicsCardService cardService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private GraphicsCardPriceService priceService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic-name.graphics-card}" , groupId = "groupId")
    public void listenGraphicsCard(@Payload String data) throws JsonProcessingException {
        GraphicsCard graphicsCard = objectMapper.readValue(data, GraphicsCard.class);

        System.out.println("Received: " + data);
        System.out.println("Object: " + graphicsCard);

        Store store = storeService.saveFromGraphicsCard(graphicsCard);
        graphicsCard = cardService.save(graphicsCard);
        priceService.saveFromStoreAndGraphicsCard(store, graphicsCard);
    }
}
