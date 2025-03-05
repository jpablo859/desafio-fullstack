package com.user.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Long id;
    private String nombres;
    private String apellidos;
    private String rut;
    private String dv;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String contrasena;
}
