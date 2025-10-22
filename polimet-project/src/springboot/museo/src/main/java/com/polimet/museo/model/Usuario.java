package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombre;
    private String email;
    private String pais;
    private String telefono;
    private java.sql.Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_membresia")
    private Membresia membresia;
}
