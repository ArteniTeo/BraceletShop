package com.BaceletShop.exception;

import com.BaceletShop.common.dto.ErrorCode;
import com.BaceletShop.common.web.BusinessException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException(String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("Invalid email address %s.", resourceName));
    }

}