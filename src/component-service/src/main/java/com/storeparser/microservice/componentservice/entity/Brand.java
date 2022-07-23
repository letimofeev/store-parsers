package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @lombok.Setter
    @lombok.Getter
    private String displayName;

    @lombok.Setter
    @lombok.Getter
    private String displayNameLower;

    public Brand() {
    }
}
