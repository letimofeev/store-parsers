package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicsCardPriceRepository extends JpaRepository<GraphicsCardPrice, Integer> {
}
