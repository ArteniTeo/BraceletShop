package com.BaceletShop.reposiory;

import com.BaceletShop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Transactional
    @Modifying
    @Query("update OrderItem o set o.quantity = ?1 where o.id = ?2")
    int updateQuantityById(int quantity, Long id);
    List<OrderItem> findByOrder_User_IdAndOrder_Status(Long id, String status);
    List<OrderItem> findByOrder_IdOrderByIdAsc(Long id);

}
