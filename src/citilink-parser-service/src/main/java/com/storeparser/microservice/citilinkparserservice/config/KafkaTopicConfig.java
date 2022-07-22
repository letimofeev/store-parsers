package com.storeparser.microservice.citilinkparserservice.config;

import com.storeparser.microservice.citilinkparserservice.broker.KafkaTopicNameFactory;
import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Autowired
    private KafkaTopicNameFactory topicNameFactory;

    public NewTopic graphicsCardTopic() {
        String graphicsCardTopicName = topicNameFactory.getTopicName(GraphicsCard.class);
        return TopicBuilder.name(graphicsCardTopicName).build();
    }
}
