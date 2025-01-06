package com.BaceletShop.service;

import com.BaceletShop.common.OrderStatus;
import com.BaceletShop.entities.OrderDetail;
import com.BaceletShop.entities.User;
import com.BaceletShop.reposiory.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository repository;
    private final UserService userService;

    public OrderDetail createOrder(OrderDetail order) {
        return repository.save(order);
    }

    //LEGACY - This method is outdated, delete when 100% sure I don't need it anymore
//    public OrderDetail updateOrder(OrderDetail order) {
//        OrderDetail orderDetail = findOrderById(order.getId());
//        if (orderDetail.getStatus().equals(OrderStatus.ORDERING)) {
//            int returnedStatus = repository.updateStatusAndTotalPriceAndShippingAddressAndOrderDateAndDeliveryDateById(order.getStatus(), order.getTotalPrice(), order.getShippingAddress(), order.getOrderDate(), order.getDeliveryDate(), order.getId());
//
//            if (returnedStatus != 0) return order;
//            else return null;
//        } else {
//            return null;
//        }
//    }

    public int placeOrder(Long userId) {
        Date dateOfPlacedOrder = Date.valueOf(LocalDate.now());

        if (isOrderIsEmpty(findShoppingCartByUserId(userId))) {
            System.err.println("User's cart is empty.");
            return -1;
        }

        if (!checkAndUpdateShippingAddress(findShoppingCartByUserId(userId))) {
            System.err.println("User's address is empty.");
            return -2;
        }

        int returnedStatus = repository.updateStatusAndOrderDateById(OrderStatus.PLACED, dateOfPlacedOrder, findShoppingCartByUserId(userId).getId());
        System.out.println("Order placed = " + returnedStatus);
        if (returnedStatus == 1) {
            System.out.println("New empty shopping cart created.");
            createShoppingCart(userService.getUserById(userId));
        }
        return returnedStatus;
    }

    private boolean isOrderIsEmpty(OrderDetail shoppingCartByUserId) {
        return shoppingCartByUserId.getTotalPrice() == 0;
    }

    private boolean checkAndUpdateShippingAddress(OrderDetail shoppingCart) {
        if (!shoppingCart.isAddressEmpty()) {
            return true;
        }
        if (!shoppingCart.getUser().isAddressEmpty()) {
            updateAddress(shoppingCart.getUser().getAddress(), shoppingCart.getId());
            return true;
        }
        return false;
    }

    private int updateAddress(String newAddress, Long orderId) {
        return repository.updateShippingAddressById(newAddress, orderId);
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

    public int updatePrice(Long newTotalPrice, Long id) {
        return repository.updateTotalPriceById(newTotalPrice, id);
    }

    public OrderDetail createShoppingCart(User newUser) {
        return repository.save(new OrderDetail(newUser));
    }
}
