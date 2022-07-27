package com.storeparser.microservice.componentservice.controller;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardRaw;
import com.storeparser.microservice.componentservice.service.graphicscard.GraphicsCardRawService;
import com.storeparser.microservice.componentservice.service.graphicscard.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GraphicsCardController {

    @Autowired
    private GraphicsCardService cardService;

    @Autowired
    private GraphicsCardRawService cardRawService;

    @GetMapping("/graphics-cards")
    public List<GraphicsCard> findAllGraphicsCards() {
        return cardService.findAll();
    }

    @GetMapping("/graphics-cards/{id}")
    public GraphicsCard findGraphicsCard(@PathVariable int id) {
        return cardService.findById(id);
    }

    @PostMapping("/graphics-cards")
    public GraphicsCard addGraphicsCard(@RequestBody GraphicsCardRaw graphicsCardRaw) {
        return cardRawService.saveWithDependencies(graphicsCardRaw);
    }

    @PutMapping("/graphics-cards")
    public GraphicsCard updateGraphicsCard(@RequestBody GraphicsCard graphicsCard) {
        return cardService.update(graphicsCard);
    }
}
