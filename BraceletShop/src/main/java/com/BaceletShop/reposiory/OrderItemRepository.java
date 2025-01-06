package com.BaceletShop.reposiory;

import com.BaceletShop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder_User_IdAndOrder_Status(Long id, String status);
    List<OrderItem> findByOrder_IdOrderByIdAsc(Long id);

}
