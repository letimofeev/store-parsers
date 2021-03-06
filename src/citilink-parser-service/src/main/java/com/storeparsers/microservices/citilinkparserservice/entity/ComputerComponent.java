package com.storeparsers.microservices.citilinkparserservice.entity;

public abstract class ComputerComponent {

    protected String displayTitle;
    protected String url;
    protected String imageUrl;
    protected int price;
    protected boolean isStock;

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
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

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }
}
