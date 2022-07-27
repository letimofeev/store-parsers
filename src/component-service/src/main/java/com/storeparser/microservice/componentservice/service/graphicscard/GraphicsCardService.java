package com.storeparser.microservice.componentservice.service.graphicscard;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;

import java.util.List;

public interface GraphicsCardService {

    List<GraphicsCard> findAll();

    GraphicsCard findById(int id);

    GraphicsCard save(GraphicsCard graphicsCard);

    GraphicsCard update(GraphicsCard graphicsCard);
}
