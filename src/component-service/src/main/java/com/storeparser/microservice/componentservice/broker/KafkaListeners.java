package com.storeparser.microservice.componentservice.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.service.ComputerComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {

    @Autowired
    private ComputerComponentService componentService;

    @RetryableTopic
    @KafkaListener(topics = "${kafka.topic-name.graphics-card}" , groupId = "groupId")
    public void listenGraphicsCard(@Payload String graphicsCardRawJson) {
        log.info("Raw graphics card json received: {}", graphicsCardRawJson);
        GraphicsCard graphicsCard =
                componentService.saveGraphicsCardWithDependent(graphicsCardRawJson);
        log.info("Saved graphics card: {}", graphicsCard);
    }
}
