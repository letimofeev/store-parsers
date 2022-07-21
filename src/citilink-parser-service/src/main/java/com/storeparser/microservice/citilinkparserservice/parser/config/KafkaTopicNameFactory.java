package com.storeparser.microservice.citilinkparserservice.parser.config;

import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicNameFactory {

    @Autowired
    private KafkaTopicNames kafkaTopicNames;

    public <T extends ComputerComponent> String getTopicName(Class<T> type) {
        if (type.equals(GraphicsCard.class)) {
            return kafkaTopicNames.getGraphicsCard();
        }
        throw new IllegalArgumentException(String.format(
                "Kafka topic name for type = %s not found",
                type.getName()));
    }
}
