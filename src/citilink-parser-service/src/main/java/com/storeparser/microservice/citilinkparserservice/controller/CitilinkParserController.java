package com.storeparser.microservice.citilinkparserservice.controller;

import com.storeparser.microservice.citilinkparserservice.config.CitilinkUrls;
import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.service.ComputerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CitilinkParserController {

    @Autowired
    private CitilinkUrls citilinkUrls;

    @Autowired
    private ComputerComponentService componentService;

    @GetMapping("/graphics-card")
    public @ResponseBody
    GraphicsCard retrieveOne() {
        String graphicsCardUrl = citilinkUrls.getGraphicsCardUrl();
        componentService.parseAll(graphicsCardUrl, GraphicsCard.class);
        return null;
    }
}
