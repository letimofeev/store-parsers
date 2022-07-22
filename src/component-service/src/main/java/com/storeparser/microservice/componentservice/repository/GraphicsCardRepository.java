package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicsCardRepository extends JpaRepository<GraphicsCard, Integer> {
}
