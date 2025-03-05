package com.user.infraestructure.adapters.in.rest.controller.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String rut;
    private String dv;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
}
