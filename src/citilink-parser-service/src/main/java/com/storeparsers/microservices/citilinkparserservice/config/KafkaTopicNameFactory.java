package com.storeparsers.microservices.citilinkparserservice.config;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.entity.GraphicsCard;
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
