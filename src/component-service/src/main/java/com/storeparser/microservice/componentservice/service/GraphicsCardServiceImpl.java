package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.repository.GraphicsCardRepository;
import com.storeparser.microservice.componentservice.utils.GraphicsCardExistenceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class GraphicsCardServiceImpl implements GraphicsCardService {

    @Autowired
    private GraphicsCardRepository cardRepository;

    @Autowired
    private GraphicsCardExistenceResolver existenceResolver;

    @Override
    public List<GraphicsCard> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public GraphicsCard findById(int id) {
        Optional<GraphicsCard> cardOptional = cardRepository.findById(id);
        if (cardOptional.isEmpty()) {
            throw new NoSuchElementException(String.format(
                    "There is no GraphicsCard with ID = %d in Database", id));
        }
        return cardOptional.get();
    }

    @Override
    public GraphicsCard save(GraphicsCard graphicsCard) {
        existenceResolver.resolveSameCardExistence(graphicsCard);
        if (!existenceResolver.isFound()) {
            cardRepository.save(graphicsCard);
        }
        return graphicsCard;
    }

    @Override
    public GraphicsCard update(GraphicsCard graphicsCard) {
        return cardRepository.save(graphicsCard);
    }
}
