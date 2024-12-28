package com.BaceletShop.controller;

import com.BaceletShop.entities.OrderDetail;
import com.BaceletShop.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService service;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderDetail insertOrder(@RequestBody OrderDetail order) {
        return service.createOrder(order);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public OrderDetail findByOrderId(@RequestParam(value = "id") Long id) {
        return service.findOrderById(id);
    }

    @GetMapping(value = "/orders")
    public List<OrderDetail> findOrders(@RequestParam(value = "id") Long id) {
        return service.findOrdersByUserId(id);
    }

}
