package com.storeparsers.microservices.citilinkparserservice.parser.properties;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.entity.CitilinkGraphicsCard;

import java.util.Map;

public class ComputerComponentProperties {

    public static void doSetProperties(ComputerComponent component, Map<String, String> properties) {
        if (component instanceof CitilinkGraphicsCard graphicsCard) {
            GraphicsCardProperties.doSetProperties(graphicsCard, properties);
        }
    }
}
