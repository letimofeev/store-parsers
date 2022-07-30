package com.storeparser.microservice.citilinkparserservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
