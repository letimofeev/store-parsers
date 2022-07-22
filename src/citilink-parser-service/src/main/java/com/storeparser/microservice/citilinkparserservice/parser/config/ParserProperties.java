package com.storeparser.microservice.citilinkparserservice.parser.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "citilink.parser")
public class ParserProperties {

    private int timeout;
    private int maxThreadNumber;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxThreadNumber() {
        return maxThreadNumber;
    }

    public void setMaxThreadNumber(int maxThreadNumber) {
        this.maxThreadNumber = maxThreadNumber;
    }
}
