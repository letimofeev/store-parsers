package com.storeparser.microservice.componentservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GraphicsCardRaw {

    private String serialIdentifier;
    private String displayTitle;
    private String model;
    private String url;
    private String imageUrl;
    private String storeDisplayName;
    private String vendorName;
    private String connector;
    private String busWidth;
    private String videoChipset;
    private String videoMemoryFrequency;
    private String videoMemorySize;
    private String videoMemoryType;
    private String technologySupport;
    private String additionalPowerConnectors;
    private String recommendedPowerSupply;
    private String GPUFrequency;
    private int price;
    private boolean stock;
}
