package com.storeparser.microservice.citilinkparserservice.controller;

import com.storeparser.microservice.citilinkparserservice.parser.config.CitilinkUrls;
import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.service.ComputerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/parse")
public class CitilinkParserController {

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
}
