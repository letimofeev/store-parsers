package com.storeparser.microservice.citilinkparserservice.entity;

public abstract class ComputerComponent {

    protected String serialIdentifier;
    protected String displayTitle;
    protected String vendorName;
    protected String model;
    protected String url;
    protected String imageUrl;
    protected int price;
    protected String storeDisplayName;
    protected boolean stock;

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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStoreDisplayName() {
        return storeDisplayName;
    }

    public void setStoreDisplayName(String storeDisplayName) {
        this.storeDisplayName = storeDisplayName;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
}
