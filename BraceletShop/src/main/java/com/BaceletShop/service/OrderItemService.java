package com.BaceletShop.service;

import com.BaceletShop.common.OrderStatus;
import com.BaceletShop.entities.OrderItem;
import com.BaceletShop.entities.Product;
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
    private final OrderDetailService ODS;
    private final ProductService pS;

    //Used for finding single Items by id in order to update.
    public OrderItem findById(Long id) {
        return repository.findById(id).orElse(new OrderItem());
    }

    //TODO For testing purposes
    public List<OrderItem> getAllItems() {
        return repository.findAll();
    }

    public List<OrderItem> getItemsFromUsersShoppingCart(Long id) {
        return repository.findByOrder_User_IdAndOrder_Status(id, OrderStatus.ORDERING);
    }

    //Find the items in a users ShoppingCart
    public List<OrderItem> getUserShoppingCartItems(Long id) {
        return repository.findByOrder_IdOrderByIdAsc(id);
    }

    //Adding an item to a users Shopping Cart
    public OrderItem createItem(OrderItem item) {
        return repository.save(item);
    }

    public OrderItem addToCart(Long prodId, Long userId, int quantity) {
        Product prodToBeAdded = pS.findProductById(prodId);
        OrderItem itemToAddToCart = new OrderItem(ODS.findShoppingCartByUserId(userId), prodToBeAdded, quantity);
        return repository.save(itemToAddToCart);
    }

    public void deleteItem(Long id) {
        repository.delete(findById(id));
    }
}
