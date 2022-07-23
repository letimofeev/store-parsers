package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.Brand;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;

public interface BrandService {

    Brand saveFromGraphicsCard(GraphicsCard graphicsCard);
}
