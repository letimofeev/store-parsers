package com.storeparser.microservice.componentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "graphics_card")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphicsCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialIdentifier;
    private String displayTitle;
    private String model;
    private String imageUrl;
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}
