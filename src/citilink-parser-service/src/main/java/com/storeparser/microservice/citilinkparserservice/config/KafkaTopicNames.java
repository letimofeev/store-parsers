package com.storeparser.microservice.citilinkparserservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "kafka.topic-name")
public class KafkaTopicNames {

    private String graphicsCard;
}
