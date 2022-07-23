package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.Store;

public interface StoreService {

    Store saveFromGraphicsCard(GraphicsCard graphicsCard);
}
