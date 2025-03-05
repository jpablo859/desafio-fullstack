package com.user.infraestructure.adapters.in.rest.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateUserRequest extends CreateUserRequest {
    @NotNull
    private Long id;
}
