package com.BaceletShop.common.web;

import com.BaceletShop.common.dto.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;
    @Setter
    private String methodName;

    public BusinessException(String message) {
        this(ErrorCode.BAD_REQUEST_DATA, message);
    }

    public BusinessException(String message, Throwable throwable) {
        this(ErrorCode.BAD_REQUEST_DATA, message, throwable);
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = errorCode;
    }
}


