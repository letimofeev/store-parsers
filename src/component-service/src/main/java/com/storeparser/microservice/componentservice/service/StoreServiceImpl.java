package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
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
    public Store saveFromGraphicsCard(GraphicsCard graphicsCard) {
        String storeShortName = graphicsCard.getStoreShortName();
        Optional<Store> storeOptional = storeRepository.findByShortName(storeShortName);
        Store store;
        if (storeOptional.isEmpty()) {
            store = new Store();
            store.setShortName(storeShortName);
            store.setDisplayName(graphicsCard.getStoreDisplayName());
            storeRepository.save(store);
        } else {
            store = storeOptional.get();
        }
        return store;
    }
}
