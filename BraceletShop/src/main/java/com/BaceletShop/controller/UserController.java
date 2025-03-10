package com.BaceletShop.controller;

import com.BaceletShop.entities.User;
import com.BaceletShop.service.OrderDetailService;
import com.BaceletShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService service;
    private final OrderDetailService orderDetailService;

    @GetMapping(value = "/login")
    public User login(@RequestParam(value = "identifier") String identifier,
                      @RequestParam(value = "password") String password) {
        return service.login(identifier, password);
    }

    @GetMapping(value = "/user")
    public User getUserById(@RequestParam(value = "id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping(value = "/user")
    public User signup(@RequestBody User user) {
        User newUser = service.createUser(user);
        orderDetailService.createShoppingCart(newUser);
        return newUser;
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(value = "id") Long id) {
        service.removeUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}
