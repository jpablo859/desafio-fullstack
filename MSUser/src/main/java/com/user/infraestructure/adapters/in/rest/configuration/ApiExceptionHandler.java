package com.user.infraestructure.adapters.in.rest.configuration;

import com.user.application.exceptions.ApiException;
import com.user.infraestructure.adapters.in.rest.controller.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(ApiException ex) {
        ApiResponse<Object> response = ApiResponse.error(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return new ApiResponse<>("400", false, LocalDateTime.now(), "Errores de validación", errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(Exception ex) {
        ApiResponse<Object> response = ApiResponse.error("500", "Ocurrió un error inesperado: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
