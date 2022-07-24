package com.storeparser.microservice.componentservice.controller;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphicsCardController {

    @Autowired
    private GraphicsCardService cardService;

    @GetMapping("/graphics-cards/{id}")
    public GraphicsCard getGraphicsCard(@PathVariable int id) {
        return cardService.findById(id);
    }
}
