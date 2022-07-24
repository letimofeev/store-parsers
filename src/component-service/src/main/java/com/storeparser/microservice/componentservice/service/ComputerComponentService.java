package com.storeparser.microservice.componentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;

public interface ComputerComponentService {

    GraphicsCard saveGraphicsCardWithDependent(String graphicsCardRawJson)
            throws JsonProcessingException;
}
