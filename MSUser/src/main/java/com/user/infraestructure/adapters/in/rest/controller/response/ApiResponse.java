package com.user.infraestructure.adapters.in.rest.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Estructura de respuesta estándar de la API")
public class ApiResponse<T> {
    @Schema(description = "Código de estado de la respuesta", example = "200")
    private String statusCode;

    @Schema(description = "Indica si la operación fue exitosa", example = "true")
    private Boolean isSuccess;

    @Schema(description = "Fecha y hora de la transacción", example = "2024-03-06T10:30:00")
    private LocalDateTime transactionDate;

    @Schema(description = "Mensaje descriptivo de la respuesta", example = "Operación exitosa")
    private String message;

    @Schema(description = "Datos de la respuesta")
    private T data;

    public static <T> ApiResponse<T> success(T data, String statusCode) {
        return new ApiResponse<>(statusCode, true, LocalDateTime.now(), "Transacción exitosa", data);
    }

    public static ApiResponse<Object> error(String statusCode, String message) {
        return new ApiResponse<>(statusCode, false, LocalDateTime.now(), message, null);
    }
}