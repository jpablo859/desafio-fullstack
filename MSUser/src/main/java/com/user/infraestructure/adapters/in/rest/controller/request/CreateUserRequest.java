package com.user.infraestructure.adapters.in.rest.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CreateUserRequest {
    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    private String rut;

    @NotNull
    private String dv;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;

    @NotNull
    private String correoElectronico;

    @NotNull
    private String contrasena;
}
