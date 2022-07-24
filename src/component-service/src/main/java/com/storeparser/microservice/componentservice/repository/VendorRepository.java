package com.storeparser.microservice.componentservice.repository;

import com.storeparser.microservice.componentservice.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    Optional<Vendor> findByDisplayNameLower(String displayNameLower);
}
