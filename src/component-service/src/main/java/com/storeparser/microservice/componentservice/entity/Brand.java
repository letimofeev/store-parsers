package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;
import java.util.Locale;

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

    public Brand(String displayName) {
        this.displayName = displayName;
        displayNameLower = displayName.toLowerCase(Locale.ROOT);
    }
}
