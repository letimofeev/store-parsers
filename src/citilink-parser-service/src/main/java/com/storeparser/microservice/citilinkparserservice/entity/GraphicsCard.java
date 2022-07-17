package com.storeparser.microservice.citilinkparserservice.entity;

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

    public GraphicsCard() {
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

    public String getGPUFrequency() {
        return GPUFrequency;
    }

    public void setGPUFrequency(String GPUFrequency) {
        this.GPUFrequency = GPUFrequency;
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
}
