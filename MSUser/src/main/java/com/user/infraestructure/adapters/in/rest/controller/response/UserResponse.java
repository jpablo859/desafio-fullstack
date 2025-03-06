package com.user.infraestructure.adapters.in.rest.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Respuesta con los datos del usuario")
public class UserResponse {
    @Schema(description = "ID del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombres del usuario", example = "Juan Pablo")
    private String nombres;

    @Schema(description = "Apellidos del usuario", example = "Saldarriaga")
    private String apellidos;

    @Schema(description = "RUT sin dígito verificador", example = "12345678")
    private String rut;

    @Schema(description = "Dígito verificador del RUT", example = "K")
    private String dv;

    @Schema(description = "Fecha de nacimiento", example = "1990-01-01")
    private LocalDate fechaNacimiento;

    @Schema(description = "Correo electrónico", example = "juan.saldarriaga@ejemplo.com")
    private String correoElectronico;
}
