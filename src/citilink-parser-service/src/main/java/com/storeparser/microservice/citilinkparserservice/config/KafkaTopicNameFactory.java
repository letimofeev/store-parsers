package com.storeparser.microservice.citilinkparserservice.config;

import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicNameFactory {

    @Value("${kafka.topic.graphics-card}")
    private String graphicsCardTopicName;

    public <E extends ComputerComponent> String getTopicName(Class<E> type) {
        if (type.equals(GraphicsCard.class)) {
            return graphicsCardTopicName;
        }
        throw new IllegalArgumentException(String.format(
                "Kafka topic name for type = %s not found",
                type.getName()));
    }
}
