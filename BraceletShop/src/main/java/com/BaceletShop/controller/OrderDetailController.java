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

    @PostMapping(value = "/order")
    public OrderDetail insertOrder(@RequestBody OrderDetail order) {
        return service.createOrder(order);
    }


    @GetMapping(value = "/order")
    public OrderDetail findByOrderId(@RequestParam(value = "id") Long id) {
        return service.findOrderById(id);
    }

    //Only orders with the status "ORDERING" (the users shopping cart) can be updated.
    @PutMapping(value = "/order")
    public OrderDetail updateOrder(@RequestBody OrderDetail order) {
        return service.updateOrder(order);
    }


    //Get the users current shopping
    @GetMapping(value = "/shoppingCart")
    public OrderDetail findShoppingCart(@RequestParam(value = "id") Long id) {
        return service.findShoppingCartByUserId(id);
    }

    //Get the users currently placed orders (that are en route)
    @GetMapping(value = "/placedOrders")
    public List<OrderDetail> findPlacedOrders(@RequestParam(value = "id") Long id) {
        return service.findPlacedOrdersByUserId(id);
    }

    //Get the users completed orders (that have been successfully delivered)
    @GetMapping(value = "/completedOrders")
    public List<OrderDetail> findCompletedOrders(@RequestParam(value = "id") Long id) {
        return service.findCompletedOrdersByUserId(id);
    }

}
