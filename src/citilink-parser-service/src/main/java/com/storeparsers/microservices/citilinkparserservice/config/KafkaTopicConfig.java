package com.storeparsers.microservices.citilinkparserservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic graphicsCardTopic() {
        return TopicBuilder.name("graphics-card").build();
    }
}
