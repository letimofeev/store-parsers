package com.storeparser.microservice.componentservice.controller;

import com.storeparser.microservice.componentservice.entity.GraphicsCard;
import com.storeparser.microservice.componentservice.entity.GraphicsCardRaw;
import com.storeparser.microservice.componentservice.service.ComputerComponentService;
import com.storeparser.microservice.componentservice.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GraphicsCardController {

    @Autowired
    private GraphicsCardService cardService;

    @Autowired
    private ComputerComponentService componentService;

    @GetMapping("/graphics-cards/{id}")
    public GraphicsCard getGraphicsCard(@PathVariable int id) {
        return cardService.findById(id);
    }

    @PostMapping("/graphics-cards")
    public GraphicsCard addGraphicsCard(@RequestBody GraphicsCardRaw graphicsCardRaw) {
        return componentService.saveGraphicsCardWithDependent(graphicsCardRaw);
    }
}
