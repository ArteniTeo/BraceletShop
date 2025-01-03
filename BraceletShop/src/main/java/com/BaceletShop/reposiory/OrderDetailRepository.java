package com.BaceletShop.reposiory;

import com.BaceletShop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Transactional
    @Modifying
    @Query("""
            update OrderDetail o set o.status = ?1, o.totalPrice = ?2, o.shippingAddress = ?3, o.orderDate = ?4, o.deliveryDate = ?5
            where o.id = ?6""")
    int updateStatusAndTotalPriceAndShippingAddressAndOrderDateAndDeliveryDateById(
            String status, Long totalPrice,
            String shippingAddress, Date orderDate,
            Date deliveryDate, Long id);

    OrderDetail findOrderDetailById(Long id);

    //todo Find use or delete
    List<OrderDetail> findOrderDetailByUserId(Long id);

    OrderDetail findByUser_IdAndStatus(Long id, String status);

    List<OrderDetail> findByUser_IdAndStatusOrderByOrderDateDesc(Long id, String status);

}
