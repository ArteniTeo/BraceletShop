package com.BaceletShop.reposiory;

import com.BaceletShop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    OrderDetail findOrderDetailById(Long id);

    List<OrderDetail> findOrderDetailByUserId(Long id);

}
