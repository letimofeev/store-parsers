package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.repository.GraphicsCardRepository;
import com.storeparser.microservice.componentservice.utils.GraphicsCardExistenceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GraphicsCardServiceImpl implements GraphicsCardService {

    @Autowired
    private GraphicsCardRepository cardRepository;

    @Autowired
    private GraphicsCardExistenceResolver existenceResolver;

    @Override
    public void save(GraphicsCard graphicsCard) {
        existenceResolver.resolveSameCardExistence(graphicsCard);
        if (!existenceResolver.isFound()) {
            cardRepository.save(graphicsCard);
        }
    }
}
