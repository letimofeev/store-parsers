package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;

public interface GraphicsCardService {

    GraphicsCard save(GraphicsCard graphicsCard);

    GraphicsCard update(GraphicsCard graphicsCard);

    GraphicsCard findById(int id);
}
