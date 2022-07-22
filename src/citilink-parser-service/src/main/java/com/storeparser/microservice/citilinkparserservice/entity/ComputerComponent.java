package com.storeparser.microservice.citilinkparserservice.entity;

public abstract class ComputerComponent {

    protected String displayTitle;
    protected String displayTitleLower;
    protected String url;
    protected String imageUrl;
    protected int price;
    protected String storeName;
    protected String storeNameLower;
    protected boolean isStock;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreNameLower() {
        return storeNameLower;
    }

    public void setStoreNameLower(String storeNameLower) {
        this.storeNameLower = storeNameLower;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }
}
