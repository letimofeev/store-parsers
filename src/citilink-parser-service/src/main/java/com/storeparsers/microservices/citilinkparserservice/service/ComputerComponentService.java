package com.storeparsers.microservices.citilinkparserservice.service;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;

public interface ComputerComponentService {

    <E extends ComputerComponent> void parseAll(String url, Class<E> requiredType);
}
