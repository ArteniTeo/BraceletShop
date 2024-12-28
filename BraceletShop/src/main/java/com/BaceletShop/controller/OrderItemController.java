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

    @GetMapping(value = "/items")
    public List<OrderItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping(value = "/item")
    public OrderItem getItemById(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/item")
    public ResponseEntity<OrderItem> createAppointment(@RequestBody OrderItem item) {
        OrderItem createdItem = service.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping(value = "/deleteItem")
    public void deleteItem(@RequestParam(value = "id") Long id) {
        service.deleteItem(id);
    }

}