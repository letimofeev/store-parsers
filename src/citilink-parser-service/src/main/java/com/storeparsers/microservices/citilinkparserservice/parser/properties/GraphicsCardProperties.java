package com.storeparsers.microservices.citilinkparserservice.parser.properties;

import com.storeparsers.microservices.citilinkparserservice.entity.GraphicsCard;

import java.util.Map;

public class GraphicsCardProperties {

    private final String VIDEO_CHIPSET = "Видеочипсет";
    private final String GPU_FREQUENCY = "Частота графического процессора";
    private final String VIDEO_MEMORY_FREQUENCY = "Частота видеопамяти";
    private final String VIDEO_MEMORY_SIZE = "Объем видеопамяти";
    private final String VIDEO_MEMORY_TYPE = "Тип видеопамяти";
    private final String TECHNOLOGY_SUPPORT = "Поддержка технологий";
    private final String ADDITIONAL_POWER_CONNECTORS = "Разъемы дополнительного питания";
    private final String RECOMMENDED_POWER_SUPPLY = "Рекомендуемая производителем мощность БП";

    private final Map<String, String> properties;

    public GraphicsCardProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void doSetProperties(GraphicsCard graphicsCard) {
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
