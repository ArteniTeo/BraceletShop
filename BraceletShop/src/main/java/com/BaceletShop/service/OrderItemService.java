package com.BaceletShop.service;

import com.BaceletShop.common.OrderStatus;
import com.BaceletShop.entities.OrderDetail;
import com.BaceletShop.entities.OrderItem;
import com.BaceletShop.entities.Product;
import com.BaceletShop.reposiory.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;
    private final OrderDetailService orderDetailService;
    private final ProductService productService;
    private final UserService userService;

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

    //TODO - refactoring and test cases
    public OrderItem addToCart(Long prodId, Long userId, int quantity) {
        Product prodToBeAdded = productService.findProductById(prodId);
        OrderDetail shoppingCart = orderDetailService.findShoppingCartByUserId(userId);

        //Checking if this product already exists in the users shopping cart
        OrderItem checkForExisting = checkForExistingItemsAndChangeQuantity(getItemsFromUsersShoppingCart(userId), prodId, quantity);

        //Update the shopping carts total price.
        orderDetailService.updatePrice(shoppingCart.getTotalPrice() + prodToBeAdded.getPrice() * quantity, shoppingCart.getId());

        //if it exists update the products quantity instead of adding a new one
        if (checkForExisting != null)
            if (updateQuantity(checkForExisting) != 0)
                return null;
            else
                return new OrderItem(-1L);

        OrderItem itemToAddToCart = new OrderItem(shoppingCart, prodToBeAdded, quantity);
        return repository.save(itemToAddToCart);
    }

    public int updateQuantity(OrderItem updateItem) {
        return repository.updateQuantityById(updateItem.getQuantity(), updateItem.getId());
    }

    private OrderItem checkForExistingItemsAndChangeQuantity(List<OrderItem> shoppingCart, Long prodId, int quantityToBeAdded) {
        for (OrderItem itemToBeUpdated : shoppingCart) {
            if (Objects.equals(itemToBeUpdated.getProduct().getId(), prodId)) {
                itemToBeUpdated.setQuantity(itemToBeUpdated.getQuantity() + quantityToBeAdded);
                return itemToBeUpdated;
            }
        }
        return null;
    }

    public void deleteItem(Long id) {
        repository.delete(findById(id));
    }


}
