package com.BaceletShop.service;

import com.BaceletShop.entities.OrderDetail;
import com.BaceletShop.entities.User;
import com.BaceletShop.exception.UserNotFoundException;
import com.BaceletShop.reposiory.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

//import static com.DocDB.validator.UserValidator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderDetailService orderDetailService;

    public User createUser(User user) {
        if (!isEmailValid(user.getEmail())) throw new RuntimeException("Invalid email.");
//        verifyPassword(user.getPassword());
        if (findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already in use.");
        if (findByUsername(user.getUsername()) != null) throw new RuntimeException("Username already in use.");

        user.setRole("CLIENT");

        User newUser = userRepository.save(user);

        OrderDetail shoppingCart = new OrderDetail(newUser);
        orderDetailService.createOrder(shoppingCart);

        return newUser;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User login(String identifier, String password) {
        if (isEmailValid(identifier))
            return userRepository.findByEmailAndPassword(identifier, password).orElse(new User(0L));
        else
            return userRepository.findByUsernameAndPassword(identifier, password).orElse(new User(0L));
    }

    private boolean isEmailValid(String identifier) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        return identifier != null && p.matcher(identifier).matches();
    }

    @Cacheable("users")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseGet(() -> {
            log.warn("user not found for id {}", id);
            throw new UserNotFoundException(id);
        });
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
