package com.user.application.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private final String statusCode;

    public ApiException(String statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
