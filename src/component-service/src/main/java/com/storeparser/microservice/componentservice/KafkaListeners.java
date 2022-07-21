package com.storeparser.microservice.componentservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "${kafka.topic.graphics-card}" , groupId = "groupId")
    public void listener(@Payload String data) {
        System.out.println("Received: " + data);
    }
}
