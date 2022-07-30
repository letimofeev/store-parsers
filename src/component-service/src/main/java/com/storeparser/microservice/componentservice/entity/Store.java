package com.storeparser.microservice.componentservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Locale;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String displayName;
    private String displayNameLower;

    public Store(String displayName) {
        this.displayName = displayName;
        displayNameLower = displayName.toLowerCase(Locale.ROOT);
    }
}
