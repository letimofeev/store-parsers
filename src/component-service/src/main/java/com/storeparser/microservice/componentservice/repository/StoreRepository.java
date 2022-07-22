package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    Optional<Store> findByShortName(String shortName);
}
