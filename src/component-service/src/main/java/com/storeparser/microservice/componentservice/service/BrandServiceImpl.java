package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.Brand;
import com.storeparser.microservice.componentservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand save(Brand brand) {
        String displayNameLower = brand.getDisplayNameLower();
        Optional<Brand> brandOptional =
                brandRepository.findByDisplayNameLower(displayNameLower);
        if (brandOptional.isEmpty()) {
            return brandRepository.save(brand);
        }
        int id = brandOptional.get().getId();
        brand.setId(id);
        return brand;
    }
}
