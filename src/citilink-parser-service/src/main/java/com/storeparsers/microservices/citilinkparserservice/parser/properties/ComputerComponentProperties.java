package com.storeparsers.microservices.citilinkparserservice.parser.properties;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.entity.GraphicsCard;

import java.util.Map;

public class ComputerComponentProperties {

    public static void doSetProperties(ComputerComponent component, Map<String, String> properties) {
        if (component instanceof GraphicsCard graphicsCard) {
            GraphicsCardProperties.doSetProperties(graphicsCard, properties);
        }
    }
}
