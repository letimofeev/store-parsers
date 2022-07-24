package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "store")
public class Store {

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

    public Store() {
    }

    public Store(String displayName) {
        this.displayName = displayName;
        displayNameLower = displayName.toLowerCase(Locale.ROOT);
    }
}
