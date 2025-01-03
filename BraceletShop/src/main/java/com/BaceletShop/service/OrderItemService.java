package com.BaceletShop.service;

import com.BaceletShop.entities.OrderItem;
import com.BaceletShop.reposiory.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;

    //Used for finding Items by id.
    public OrderItem findById(Long id) {
        return repository.findById(id).orElse(new OrderItem());
    }

    //TODO For testing purposes
    public List<OrderItem> getAllItems() {
        return repository.findAll();
    }

    //Adding an item to a users Shopping Cart
    public OrderItem createItem(OrderItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.delete(findById(id));
    }
}
