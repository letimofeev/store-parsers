package com.storeparsers.microservices.citilinkparserservice.controller;

import com.storeparsers.microservices.citilinkparserservice.config.CitilinkUrls;
import com.storeparsers.microservices.citilinkparserservice.entity.CitilinkGraphicsCard;
import com.storeparsers.microservices.citilinkparserservice.service.ComputerComponentService;
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
    CitilinkGraphicsCard retrieveOne() {
        String graphicsCardUrl = citilinkUrls.getGraphicsCardUrl();
        componentService.parseAll(graphicsCardUrl, CitilinkGraphicsCard.class);
        return null;
    }
}
