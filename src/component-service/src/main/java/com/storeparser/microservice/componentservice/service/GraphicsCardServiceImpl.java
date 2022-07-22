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
        String displayTitleLower = graphicsCard.getDisplayTitleLower();
        String videoChipset = graphicsCard.getVideoChipset();
        Optional<GraphicsCard> cardOptional =
                cardRepository.findByDisplayTitleLowerAndVideoChipset(displayTitleLower,
                        videoChipset);
        if (cardOptional.isEmpty()) {
            cardRepository.save(graphicsCard);
        } else {
            int cardId = cardOptional.get().getId();
            graphicsCard.setId(cardId);
        }
        return graphicsCard;
    }

}
