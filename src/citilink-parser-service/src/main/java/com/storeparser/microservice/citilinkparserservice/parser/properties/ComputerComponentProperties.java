package com.storeparser.microservice.citilinkparserservice.parser.properties;

import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;
import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;

import java.util.Map;

public class ComputerComponentProperties {

    public static void doSetProperties(ComputerComponent component, Map<String, String> properties) {
        if (component instanceof GraphicsCard graphicsCard) {
            GraphicsCardProperties.doSetProperties(graphicsCard, properties);
        }
    }
}
