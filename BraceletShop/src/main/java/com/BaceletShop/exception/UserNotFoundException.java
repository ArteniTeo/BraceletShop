package com.BaceletShop.exception;

import com.BaceletShop.common.web.NotFoundException;
import com.BaceletShop.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Long id) {
        super(id, User.RESOURCE_NAME);
    }

    public UserNotFoundException(String email) {
        super(email, User.RESOURCE_NAME);
    }
}
