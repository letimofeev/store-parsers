package com.storeparser.microservice.componentservice.entity;

public class GraphicsCardRaw {

    private String serialIdentifier;
    private String displayTitle;
    private String modelName;
    private String url;
    private String imageUrl;
    private String storeDisplayName;
    private String brandName;
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

    public GraphicsCardRaw() {
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStoreDisplayName() {
        return storeDisplayName;
    }

    public void setStoreDisplayName(String storeDisplayName) {
        this.storeDisplayName = storeDisplayName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "GraphicsCardRaw{" +
                "serialIdentifier='" + serialIdentifier + '\'' +
                ", displayTitle='" + displayTitle + '\'' +
                ", modelName='" + modelName + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", storeDisplayName='" + storeDisplayName + '\'' +
                ", brandName='" + brandName + '\'' +
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
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}