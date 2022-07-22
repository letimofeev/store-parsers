package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "graphics_card")
public class GraphicsCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int storeId;
    private int price;
    private boolean isStock;
    private String displayTitle;
    private String displayTitleLower;
    private String url;
    private String imageUrl;
    private String connector;
    private String busWidth;
    private String videoChipset;

    @Column(name = "gpu_frequency")
    private String GPUFrequency;

    private String videoMemoryFrequency;
    private String videoMemorySize;
    private String videoMemoryType;
    private String technologySupport;
    private String additionalPowerConnectors;
    private String recommendedPowerSupply;
    private LocalDateTime timestamp;

    @Transient
    private String storeDisplayName;
    @Transient
    private String storeShortName;

    public GraphicsCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getDisplayTitleLower() {
        return displayTitleLower;
    }

    public void setDisplayTitleLower(String displayTitleLower) {
        this.displayTitleLower = displayTitleLower;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStoreDisplayName() {
        return storeDisplayName;
    }

    public void setStoreDisplayName(String storeDisplayName) {
        this.storeDisplayName = storeDisplayName;
    }

    public String getStoreShortName() {
        return storeShortName;
    }

    public void setStoreShortName(String storeShortName) {
        this.storeShortName = storeShortName;
    }

    @Override
    public String toString() {
        return "GraphicsCard{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", displayTitle='" + displayTitle + '\'' +
                ", displayTitleLower='" + displayTitleLower + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", storeDisplayName='" + storeDisplayName + '\'' +
                ", storeShortName='" + storeShortName + '\'' +
                ", isStock=" + isStock +
                ", connector='" + connector + '\'' +
                ", busWidth='" + busWidth + '\'' +
                ", videoChipset='" + videoChipset + '\'' +
                ", GPUFrequency='" + GPUFrequency + '\'' +
                ", videoMemoryFrequency='" + videoMemoryFrequency + '\'' +
                ", videoMemorySize='" + videoMemorySize + '\'' +
                ", videoMemoryType='" + videoMemoryType + '\'' +
                ", technologySupport='" + technologySupport + '\'' +
                ", additionalPowerConnectors='" + additionalPowerConnectors + '\'' +
                ", recommendedPowerSupply='" + recommendedPowerSupply + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
