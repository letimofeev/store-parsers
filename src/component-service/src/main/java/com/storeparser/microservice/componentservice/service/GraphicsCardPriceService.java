package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import com.storeparser.microservice.componentservice.entity.Store;

public interface GraphicsCardPriceService {

    GraphicsCardPrice saveFromStoreAndGraphicsCard(Store store, GraphicsCard graphicsCard);
}
