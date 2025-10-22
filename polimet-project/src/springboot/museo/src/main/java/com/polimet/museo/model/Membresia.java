package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMembresia;

    private String tipo;
    private String descripcion;
}
