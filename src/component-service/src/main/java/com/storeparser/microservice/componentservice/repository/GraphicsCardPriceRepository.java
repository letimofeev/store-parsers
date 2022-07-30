package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicsCardPriceRepository extends JpaRepository<GraphicsCardPrice, Integer> {

    List<GraphicsCardPrice> findAllByGraphicsCardId(int graphicsCardId);
}
