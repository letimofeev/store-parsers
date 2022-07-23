package com.storeparser.microservice.componentservice.utils;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.repository.GraphicsCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GraphicsCardExistenceResolver {

    @Autowired
    private GraphicsCardRepository cardRepository;

    private boolean isFound;

    public boolean isFound() {
        return isFound;
    }

    public void resolveSameCardExistence(GraphicsCard graphicsCard) {
        isFound = false;
        if (graphicsCard.getSerialIdentifier() != null) {
            resolveBySerialIdentifier(graphicsCard);
        } else if (graphicsCard.getModel() != null) {
            resolveByModel(graphicsCard);
        }
    }

    private void resolveBySerialIdentifier(GraphicsCard graphicsCard) {
        String serialIdentifier = graphicsCard.getSerialIdentifier();
        Optional<GraphicsCard> optionalFromBase =
                cardRepository.findBySerialIdentifier(serialIdentifier);
        resolveNullValuesIfPresent(optionalFromBase, graphicsCard);
    }

    private void resolveByModel(GraphicsCard graphicsCard) {
        String model = graphicsCard.getModel();
        Optional<GraphicsCard> optionalFromBase = cardRepository.findByModel(model);
        resolveNullValuesIfPresent(optionalFromBase, graphicsCard);
    }

    private void resolveNullValuesIfPresent(Optional<GraphicsCard> optionalFromBase,
                                            GraphicsCard addedGraphicsCard) {
        if (optionalFromBase.isPresent()) {
            GraphicsCard graphicsCardFromBase = optionalFromBase.get();
            resolveNullValues(graphicsCardFromBase, addedGraphicsCard);
            addedGraphicsCard.setId(graphicsCardFromBase.getId());
            isFound = true;
        }
    }

    private void resolveNullValues(GraphicsCard fromBase, GraphicsCard addedGraphicsCard) {
        NullValuesResolver<GraphicsCard> resolver
                = new NullValuesResolver<>(fromBase, GraphicsCard.class);
        resolver.merge(addedGraphicsCard);
        if (resolver.isModified()) {
            cardRepository.save(fromBase);
        }
    }
}
