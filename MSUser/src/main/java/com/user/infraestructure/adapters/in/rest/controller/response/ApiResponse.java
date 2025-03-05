package com.user.infraestructure.adapters.in.rest.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String statusCode;
    private Boolean isSuccess;
    private LocalDateTime transactionDate;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data, String statusCode) {
        return new ApiResponse<>(statusCode, true, LocalDateTime.now(), "Transacción exitosa", data);
    }

    public static ApiResponse<Object> error(String statusCode, String message) {
        return new ApiResponse<>(statusCode, false, LocalDateTime.now(), message, null);
    }
}