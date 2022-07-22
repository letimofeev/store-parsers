package com.storeparser.microservice.componentservice.service;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.repository.GraphicsCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GraphicsCardServiceImpl implements GraphicsCardService {

    @Autowired
    private GraphicsCardRepository cardRepository;

    @Override
    public GraphicsCard save(GraphicsCard graphicsCard) {
        String titleFormatted = graphicsCard.getTitleFormatted();
        String videoChipset = graphicsCard.getVideoChipset();
        Optional<GraphicsCard> cardOptional =
                cardRepository.findByTitleFormattedAndVideoChipset(titleFormatted, videoChipset);
        if (cardOptional.isEmpty()) {
            cardRepository.save(graphicsCard);
        } else {
            GraphicsCard graphicsCardFromBase = cardOptional.get();
            graphicsCard.setId(graphicsCardFromBase.getId());
            NullValuesResolver<GraphicsCard> resolver
                    = new NullValuesResolver<>(graphicsCardFromBase, GraphicsCard.class);
            resolver.merge(graphicsCard);
            if (resolver.isModified()) {
                cardRepository.save(graphicsCardFromBase);
            }
        }
        return graphicsCard;
    }
}
