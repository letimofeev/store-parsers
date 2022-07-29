package com.storeparser.microservice.citilinkparserservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "citilink.url")
public class CitilinkUrls {

    @lombok.Setter
    @lombok.Getter
    private String home;

    @lombok.Setter
    @lombok.Getter
    private String graphicsCard;

}
