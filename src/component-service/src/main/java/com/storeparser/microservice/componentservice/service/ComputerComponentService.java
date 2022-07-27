package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardRaw;

public interface ComputerComponentService {

    GraphicsCard saveGraphicsCardWithDependent(String graphicsCardRawJson);

    GraphicsCard saveGraphicsCardWithDependent(GraphicsCardRaw graphicsCardRaw);
}
