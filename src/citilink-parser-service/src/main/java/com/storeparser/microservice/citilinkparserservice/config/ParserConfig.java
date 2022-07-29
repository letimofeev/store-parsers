package com.storeparser.microservice.citilinkparserservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "citilink.parser")
public class ParserConfig {

    @lombok.Setter
    @lombok.Getter
    private int timeout;

    @lombok.Setter
    @lombok.Getter
    private int maxThreadNumber;
}
