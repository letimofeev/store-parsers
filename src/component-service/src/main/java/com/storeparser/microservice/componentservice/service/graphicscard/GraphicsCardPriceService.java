package com.storeparser.microservice.componentservice.service.graphicscard;

import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;

import java.util.List;

public interface GraphicsCardPriceService {

    GraphicsCardPrice save(GraphicsCardPrice cardPrice);

    List<GraphicsCardPrice> findAllByGraphicsCardId(int graphicsCardId);
}
