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
    @SequenceGenerator(
            name = "order_item_id_seq",
            sequenceName = "order_item_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_id_seq"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDetail order;

    @ManyToOne
    @JoinColumn(name = "bracelet_id", nullable = false)
    private Product product;

    private Long quantity;

    private Long price;

}
