package com.storeparser.microservice.citilinkparserservice.parser.properties;

import com.storeparser.microservice.citilinkparserservice.entity.GraphicsCard;

import java.util.Map;

public class GraphicsCardProperties {

    private static final String VIDEO_CHIPSET = "Видеочипсет";
    private static final String GPU_FREQUENCY = "Частота графического процессора";
    private static final String VIDEO_MEMORY_FREQUENCY = "Частота видеопамяти";
    private static final String VIDEO_MEMORY_SIZE = "Объем видеопамяти";
    private static final String VIDEO_MEMORY_TYPE = "Тип видеопамяти";
    private static final String TECHNOLOGY_SUPPORT = "Поддержка технологий";
    private static final String ADDITIONAL_POWER_CONNECTORS = "Разъемы дополнительного питания";
    private static final String RECOMMENDED_POWER_SUPPLY = "Рекомендуемая производителем мощность БП";

    public static void doSetProperties(GraphicsCard graphicsCard, Map<String, String> properties) {
        graphicsCard.setVideoChipset(properties.get(VIDEO_CHIPSET));
        graphicsCard.setGPUFrequency(properties.get(GPU_FREQUENCY));
        graphicsCard.setVideoMemoryFrequency(properties.get(VIDEO_MEMORY_FREQUENCY));
        graphicsCard.setVideoMemorySize(properties.get(VIDEO_MEMORY_SIZE));
        graphicsCard.setVideoMemoryType(properties.get(VIDEO_MEMORY_TYPE));
        graphicsCard.setTechnologySupport(properties.get(TECHNOLOGY_SUPPORT));
        graphicsCard.setAdditionalPowerConnectors(properties.get(ADDITIONAL_POWER_CONNECTORS));
        graphicsCard.setRecommendedPowerSupply(properties.get(RECOMMENDED_POWER_SUPPLY));
    }
}
