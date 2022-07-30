package com.storeparser.microservice.componentservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "graphics_card_price")
public class GraphicsCardPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "is_stock")
    private boolean stock;

    private int graphicsCardId;
    private int price;
    private String url;
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
