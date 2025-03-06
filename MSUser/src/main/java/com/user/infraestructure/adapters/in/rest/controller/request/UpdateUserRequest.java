package com.user.infraestructure.adapters.in.rest.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Datos para actualizar un usuario existente")
public class UpdateUserRequest extends CreateUserRequest {
    @Schema(description = "ID del usuario a actualizar", example = "1", required = true)
    @NotNull
    private Long id;
}
