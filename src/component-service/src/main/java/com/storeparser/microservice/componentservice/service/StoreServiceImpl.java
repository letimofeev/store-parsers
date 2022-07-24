package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.Store;
import com.storeparser.microservice.componentservice.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        String displayNameLower = store.getDisplayNameLower();
        Optional<Store> storeOptional =
                storeRepository.findByDisplayNameLower(displayNameLower);
        if (storeOptional.isEmpty()) {
            return storeRepository.save(store);
        }
        int id = storeOptional.get().getId();
        store.setId(id);
        return store;
    }
}
