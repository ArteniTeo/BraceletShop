package com.BaceletShop.service;

import com.BaceletShop.common.OrderStatus;
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

    //TODO Refactor this... looks ugly
    public OrderDetail updateOrder(OrderDetail order) {

        OrderDetail OD = findOrderById(order.getId());
        if (OD.getStatus().equals("ORDERING")) {
            int uhhh = repository.updateStatusAndTotalPriceAndShippingAddressAndOrderDateAndDeliveryDateById(
                    order.getStatus(), order.getTotalPrice(),
                    order.getShippingAddress(), order.getOrderDate(),
                    order.getDeliveryDate(), order.getId());

            if (uhhh != 0)
                return order;
            else
                return null;
        } else {
            return null;
        }


    }

    public OrderDetail findOrderById(Long id) {
        return repository.findOrderDetailById(id);
    }

    public OrderDetail findShoppingCartByUserId(Long id) {
        return repository.findByUser_IdAndStatus(id, OrderStatus.ORDERING);
    }

    public List<OrderDetail> findPlacedOrdersByUserId(Long id) {
        return repository.findByUser_IdAndStatusOrderByOrderDateDesc(id, OrderStatus.PLACED);
    }

    public List<OrderDetail> findCompletedOrdersByUserId(Long id) {
        return repository.findByUser_IdAndStatusOrderByOrderDateDesc(id, OrderStatus.COMPLETED);
    }

}
