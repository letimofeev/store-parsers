package com.storeparser.microservice.citilinkparserservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CitilinkUrls {

    @Value("${citilink.home.url}")
    private String homeUrl;

    @Value("${citilink.graphics-card.url}")
    private String graphicsCardUrl;

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getGraphicsCardUrl() {
        return graphicsCardUrl;
    }
}
