package com.BaceletShop.service;

import com.BaceletShop.entities.User;
import com.BaceletShop.exception.UserNotFoundException;
import com.BaceletShop.reposiory.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//import static com.DocDB.validator.UserValidator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(User user) {
//        if (!isEmailValid(user.getEmail())) throw new RuntimeException("Invalid email.");
//        verifyPassword(user.getPassword());
        if (findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already in use.");
        if (findByUsername(user.getUsername()) != null) throw new RuntimeException("Username already in use.");

        return repository.save(user);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User login(String identifier, String password) {
//        if (isEmailValid(identifier))
        return repository.findByEmailAndPassword(identifier, password).orElse(new User(0L));
//        else
//            return repository.findByUsernameAndPassword(identifier, password).orElse(new User(0L));

    }

    @Cacheable("users")
    public User getUserById(Long id) {
        return repository.findById(id).orElseGet(() -> {
            log.warn("user not found for id {}", id);
            throw new UserNotFoundException(id);
        });
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

}
