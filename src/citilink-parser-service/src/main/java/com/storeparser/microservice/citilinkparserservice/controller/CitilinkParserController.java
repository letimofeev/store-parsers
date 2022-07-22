package com.storeparser.microservice.citilinkparserservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.citilinkparserservice.config.CitilinkUrls;
import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.service.ComputerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/parse")
public class CitilinkParserController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CitilinkUrls citilinkUrls;

    @Autowired
    private ComputerComponentService componentService;

    // TODO: return info
    @GetMapping("/graphics-card")
    public @ResponseBody GraphicsCard parseAllGraphicsCards() {
        String graphicsCardUrl = citilinkUrls.getGraphicsCard();
        componentService.parseAll(graphicsCardUrl, GraphicsCard.class);
        return null;
    }

    @PostMapping("/graphics-card")
    public @ResponseBody GraphicsCard addGraphicsCard(@RequestBody GraphicsCard graphicsCard)
            throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(graphicsCard);
        kafkaTemplate.send("graphics-card", json);
        return graphicsCard;
    }
}
