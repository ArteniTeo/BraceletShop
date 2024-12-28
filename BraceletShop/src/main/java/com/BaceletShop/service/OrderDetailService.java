package com.BaceletShop.service;

import com.BaceletShop.entities.OrderDetail;
import com.BaceletShop.reposiory.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository repository;

    public OrderDetail createOrder(OrderDetail order) {
        return repository.save(order);
    }

    public OrderDetail findOrderById(Long id) {
        return repository.findOrderDetailById(id);
    }

    public List<OrderDetail> findOrdersByUserId(Long id) {
        return repository.findOrderDetailByUserId(id);
    }

}
