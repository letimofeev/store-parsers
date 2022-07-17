package com.storeparser.microservice.citilinkparserservice.service;

import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;

public interface ComputerComponentService {

    <E extends ComputerComponent> void parseAll(String url, Class<E> requiredType);
}
