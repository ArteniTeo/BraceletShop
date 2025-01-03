package com.BaceletShop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {

    //todo lab_res

    @Id
    @SequenceGenerator(
            name = "order_detail_id_seq",
            sequenceName = "order_detail_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_detail_id_seq"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ORDERING (shopping cart)
    // PLACED (user has paid and the products are en route)
    // COMPLETED (the products have been delivered)
    private String status;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    //create a shopping cart for a new user
    public OrderDetail(User user) {
        this.user = user;
        this.status = "ORDERING";
        this.totalPrice = 0L;
        this.shippingAddress = user.getAddress();
    }
}
