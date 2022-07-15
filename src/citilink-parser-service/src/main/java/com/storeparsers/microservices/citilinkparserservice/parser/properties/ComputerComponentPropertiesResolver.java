package com.storeparsers.microservices.citilinkparserservice.parser.properties;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.entity.GraphicsCard;

import java.util.Map;

public class ComputerComponentPropertiesResolver {

    public static void resolve(ComputerComponent component, Map<String, String> properties) {
        if (component instanceof GraphicsCard graphicsCard) {
            GraphicsCardPropertiesResolver.resolve(graphicsCard, properties);
        }
    }
}
