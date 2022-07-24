package com.storeparser.microservice.componentservice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
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
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "store_id")
    private Store store;

    @lombok.Setter
    @lombok.Getter
    @Column(name = "graphics_card_id")
    private int graphicsCardId;

    @lombok.Setter
    @lombok.Getter
    private int price;

    @lombok.Setter
    @lombok.Getter
    private String url;

    @lombok.Setter
    @lombok.Getter
    @Column(name = "is_stock")
    private boolean stock;

    @lombok.Setter
    @lombok.Getter
    private LocalDateTime timestamp;

    public GraphicsCardPrice(Store store, int graphicsCardId, int price,
                             String url, boolean stock) {
        this.store = store;
        this.graphicsCardId = graphicsCardId;
        this.price = price;
        this.url = url;
        this.stock = stock;
        timestamp = LocalDateTime.now();
    }
}
