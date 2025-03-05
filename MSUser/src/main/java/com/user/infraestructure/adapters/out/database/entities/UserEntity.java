package com.user.infraestructure.adapters.out.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "rut")
    private String rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "correoElectronico")
    private String  correoElectronico;

    @Column(name = "contrasena")
    private String  contrasena;
}
