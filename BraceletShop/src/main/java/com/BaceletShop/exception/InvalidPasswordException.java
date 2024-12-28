package com.BaceletShop.exception;

import com.BaceletShop.common.dto.ErrorCode;
import com.BaceletShop.common.web.BusinessException;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException(String password) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("%s with id %s was not found", password));
    }

}