package com.storeparser.microservice.componentservice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Locale;

@NoArgsConstructor
@Entity
@Table(name = "vendor")
public class Vendor {

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

    public Vendor(String displayName) {
        this.displayName = displayName;
        displayNameLower = displayName.toLowerCase(Locale.ROOT);
    }
}
