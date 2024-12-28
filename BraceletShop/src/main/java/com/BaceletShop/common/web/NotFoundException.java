package com.BaceletShop.common.web;

import com.BaceletShop.common.dto.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(String resourceId, String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("%s with id %s was not found", resourceName, resourceId));
    }

    public NotFoundException(Long resourceId, String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("%s with id %s was not found", resourceName, resourceId));
    }

    public NotFoundException(String message) {
        super(ErrorCode.BAD_REQUEST_DATA, message);
    }
}

