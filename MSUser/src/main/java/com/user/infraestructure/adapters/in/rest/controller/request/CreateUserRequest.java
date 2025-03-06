package com.user.infraestructure.adapters.in.rest.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Schema(description = "Datos para crear un nuevo usuario")
public class CreateUserRequest {
    @Schema(description = "Nombres del usuario", example = "Juan Pablo", required = true)
    @NotNull
    private String nombres;

    @Schema(description = "Apellidos del usuario", example = "Saldarriaga", required = true)
    @NotNull
    private String apellidos;

    @Schema(description = "RUT sin dígito verificador", example = "12345678", required = true)
    @NotNull
    private String rut;

    @Schema(description = "Dígito verificador del RUT", example = "K", required = true)
    @NotNull
    private String dv;

    @Schema(description = "Fecha de nacimiento", example = "1990-01-01", required = true)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;

    @Schema(description = "Correo electrónico", example = "juan.saldarriaga@ejemplo.com", required = true)
    @NotNull
    private String correoElectronico;

    @Schema(description = "Contraseña del usuario", example = "Abc123**", required = true)
    @NotNull
    private String contrasena;
}
