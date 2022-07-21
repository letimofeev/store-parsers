package com.storeparser.microservice.citilinkparserservice.service;

import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;

public interface ComputerComponentService {

    <T extends ComputerComponent> void parseAll(String url, Class<T> requiredType);
}
