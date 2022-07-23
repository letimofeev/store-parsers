package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Optional<Brand> findByDisplayNameLower(String displayNameLower);
}
