package com.storeparser.microservice.citilinkparserservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "citilink.name")
public class StoreName {

    private String displayName;
}
