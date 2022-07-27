package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardRaw;

public interface GraphicsCardRawService {

    GraphicsCard saveWithDependencies(String graphicsCardRawJson);

    GraphicsCard saveWithDependencies(GraphicsCardRaw graphicsCardRaw);
}
