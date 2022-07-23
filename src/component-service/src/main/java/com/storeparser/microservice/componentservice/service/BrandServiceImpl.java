package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.Brand;
import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand saveFromGraphicsCard(GraphicsCard graphicsCard) {
        String displayName = graphicsCard.getBrand();
        String displayNameLower = displayName.toLowerCase(Locale.ROOT);
        Optional<Brand> brandOptional = brandRepository.findByDisplayNameLower(displayNameLower);
        Brand brand;
        if (brandOptional.isEmpty()) {
            brand = new Brand();
            brand.setDisplayName(displayName);
            brand.setDisplayNameLower(displayNameLower);
            brandRepository.save(brand);
        } else {
            brand = brandOptional.get();
        }
        return brand;
    }
}
