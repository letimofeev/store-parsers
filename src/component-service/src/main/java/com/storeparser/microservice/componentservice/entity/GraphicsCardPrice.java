package com.storeparser.microservice.componentservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "graphics_card_price")
public class GraphicsCardPrice {

    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @lombok.Setter
    @lombok.Getter
    private int storeId;

    @lombok.Setter
    @lombok.Getter
    private int graphicsCardId;

    @lombok.Setter
    @lombok.Getter
    private int price;

    @lombok.Setter
    @lombok.Getter
    @Column(name = "is_stock")
    private boolean stock;

    @lombok.Setter
    @lombok.Getter
    private LocalDateTime timestamp;

    public GraphicsCardPrice() {
    }
}
