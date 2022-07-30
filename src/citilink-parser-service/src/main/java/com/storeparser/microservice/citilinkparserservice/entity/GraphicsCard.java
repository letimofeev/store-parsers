package com.storeparser.microservice.citilinkparserservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphicsCard extends ComputerComponent {

    private String connector;
    private String busWidth;
    private String videoChipset;
    private String GPUFrequency;
    private String videoMemoryFrequency;
    private String videoMemorySize;
    private String videoMemoryType;
    private String technologySupport;
    private String additionalPowerConnectors;
    private String recommendedPowerSupply;
}
