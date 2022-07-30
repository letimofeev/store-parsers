package com.storeparser.microservice.componentservice.service.graphicscard;

import com.storeparser.microservice.componentservice.entity.GraphicsCardPrice;
import com.storeparser.microservice.componentservice.repository.GraphicsCardPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphicsCardPriceServiceImpl implements GraphicsCardPriceService {

    @Autowired
    private GraphicsCardPriceRepository priceRepository;


    @Override
    public GraphicsCardPrice save(GraphicsCardPrice cardPrice) {
        return priceRepository.save(cardPrice);
    }

    @Override
    public List<GraphicsCardPrice> findAllByGraphicsCardId(int graphicsCardId) {
        return priceRepository.findAllByGraphicsCardId(graphicsCardId);
    }
}
