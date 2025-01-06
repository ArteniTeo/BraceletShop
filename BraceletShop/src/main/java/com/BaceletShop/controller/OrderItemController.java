package com.BaceletShop.controller;

import com.BaceletShop.entities.OrderItem;
import com.BaceletShop.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;

    //TODO For testing purposes
    @GetMapping(value = "/item")
    public OrderItem getItemById(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/items")
    public List<OrderItem> getAllItemsFromAUsersShoppingCart(@RequestParam(value = "id") Long id) {
        return service.getItemsFromUsersShoppingCart(id);
    }

    //For when the user adds an item to their shopping cart.
    @PostMapping(value = "/item")
    public ResponseEntity<OrderItem> createItem(@RequestBody OrderItem item) {
        OrderItem createdItem = service.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PostMapping(value = "/addToCart")
    public ResponseEntity<OrderItem> addToCart(@RequestParam Long pid, @RequestParam Long uid, @RequestParam int quantity) {
        OrderItem createdItem = service.addToCart(pid, uid, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping(value = "/deleteItem")
    public void deleteItem(@RequestParam(value = "id") Long id) {
        service.deleteItem(id);
    }

}