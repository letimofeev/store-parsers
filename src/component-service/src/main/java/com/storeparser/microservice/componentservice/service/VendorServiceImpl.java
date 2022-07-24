package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.Vendor;
import com.storeparser.microservice.componentservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor save(Vendor vendor) {
        String displayNameLower = vendor.getDisplayNameLower();
        Optional<Vendor> vendorOptional =
                vendorRepository.findByDisplayNameLower(displayNameLower);
        if (vendorOptional.isEmpty()) {
            return vendorRepository.save(vendor);
        }
        int id = vendorOptional.get().getId();
        vendor.setId(id);
        return vendor;
    }
}
