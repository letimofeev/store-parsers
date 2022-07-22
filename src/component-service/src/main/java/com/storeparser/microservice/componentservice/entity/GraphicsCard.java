package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "graphics_card")
public class GraphicsCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String displayTitle;
    private String titleFormatted;
    private String url;
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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private List<GraphicsCardPrice> prices;

    @Transient
    private String storeDisplayName;

    @Transient
    private String storeShortName;

    @Transient
    private int price;

    @Transient
    private boolean stock;

    public GraphicsCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getTitleFormatted() {
        return titleFormatted;
    }

    public void setTitleFormatted(String titleFormatted) {
        this.titleFormatted = titleFormatted;
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

    public List<GraphicsCardPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<GraphicsCardPrice> prices) {
        this.prices = prices;
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
        return "GraphicsCard{" +
                "id=" + id +
                ", stock=" + stock +
                ", displayTitle='" + displayTitle + '\'' +
                ", titleFormatted='" + titleFormatted + '\'' +
                ", url='" + url + '\'' +
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
                ", storeDisplayName='" + storeDisplayName + '\'' +
                ", storeShortName='" + storeShortName + '\'' +
                ", price=" + price +
                '}';
    }
}
