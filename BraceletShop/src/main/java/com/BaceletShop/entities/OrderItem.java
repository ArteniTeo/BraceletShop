package com.BaceletShop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {

    public static final String RESOURCE_NAME = "appointment";

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDetail order;

    @ManyToOne
    @JoinColumn(name = "bracelet_id", nullable = false)
    private Bracelet bracelet;

    private Long quantity;

    private Long price;

}
