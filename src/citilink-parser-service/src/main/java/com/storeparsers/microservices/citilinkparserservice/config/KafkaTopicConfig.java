package com.storeparsers.microservices.citilinkparserservice.config;

import com.storeparsers.microservices.citilinkparserservice.entity.CitilinkGraphicsCard;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Autowired
    private KafkaTopicNameFactory topicNameFactory;

    public NewTopic graphicsCardTopic() {
        String graphicsCardTopicName = topicNameFactory.getTopicName(CitilinkGraphicsCard.class);
        return TopicBuilder.name(graphicsCardTopicName).build();
    }
}
