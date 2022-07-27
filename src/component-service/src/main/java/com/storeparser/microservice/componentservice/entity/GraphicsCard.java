package com.storeparser.microservice.componentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private String videoMemoryFrequency;
    private String videoMemorySize;
    private String videoMemoryType;
    private String technologySupport;
    private String additionalPowerConnectors;
    private String recommendedPowerSupply;

    @Column(name = "gpu_frequency")
    private String GPUFrequency;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialIdentifier() {
        return serialIdentifier;
    }

    public void setSerialIdentifier(String serialIdentifier) {
        this.serialIdentifier = serialIdentifier;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getBusWidth() {
        return busWidth;
    }

    public void setBusWidth(String busWidth) {
        this.busWidth = busWidth;
    }

    public String getVideoChipset() {
        return videoChipset;
    }

    public void setVideoChipset(String videoChipset) {
        this.videoChipset = videoChipset;
    }

    public String getVideoMemoryFrequency() {
        return videoMemoryFrequency;
    }

    public void setVideoMemoryFrequency(String videoMemoryFrequency) {
        this.videoMemoryFrequency = videoMemoryFrequency;
    }

    public String getVideoMemorySize() {
        return videoMemorySize;
    }

    public void setVideoMemorySize(String videoMemorySize) {
        this.videoMemorySize = videoMemorySize;
    }

    public String getVideoMemoryType() {
        return videoMemoryType;
    }

    public void setVideoMemoryType(String videoMemoryType) {
        this.videoMemoryType = videoMemoryType;
    }

    public String getTechnologySupport() {
        return technologySupport;
    }

    public void setTechnologySupport(String technologySupport) {
        this.technologySupport = technologySupport;
    }

    public String getAdditionalPowerConnectors() {
        return additionalPowerConnectors;
    }

    public void setAdditionalPowerConnectors(String additionalPowerConnectors) {
        this.additionalPowerConnectors = additionalPowerConnectors;
    }

    public String getRecommendedPowerSupply() {
        return recommendedPowerSupply;
    }

    public void setRecommendedPowerSupply(String recommendedPowerSupply) {
        this.recommendedPowerSupply = recommendedPowerSupply;
    }

    public String getGPUFrequency() {
        return GPUFrequency;
    }

    public void setGPUFrequency(String GPUFrequency) {
        this.GPUFrequency = GPUFrequency;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "GraphicsCard{" +
                "id=" + id +
                ", serialIdentifier='" + serialIdentifier + '\'' +
                ", displayTitle='" + displayTitle + '\'' +
                ", model='" + model + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", connector='" + connector + '\'' +
                ", busWidth='" + busWidth + '\'' +
                ", videoChipset='" + videoChipset + '\'' +
                ", videoMemoryFrequency='" + videoMemoryFrequency + '\'' +
                ", videoMemorySize='" + videoMemorySize + '\'' +
                ", videoMemoryType='" + videoMemoryType + '\'' +
                ", technologySupport='" + technologySupport + '\'' +
                ", additionalPowerConnectors='" + additionalPowerConnectors + '\'' +
                ", recommendedPowerSupply='" + recommendedPowerSupply + '\'' +
                ", GPUFrequency='" + GPUFrequency + '\'' +
                ", vendor=" + vendor +
                '}';
    }
}
