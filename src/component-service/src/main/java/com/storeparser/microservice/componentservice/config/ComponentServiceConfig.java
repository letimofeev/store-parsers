package com.storeparser.microservice.componentservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "component-service")
public class ComponentServiceConfig {

    @lombok.Setter
    @lombok.Getter
    private int maxResponseSize;
}
