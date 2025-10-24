package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="secciones")
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeccion;

    private String ubicacion;
    private String epoca;
    private String nombre;
    private Float nivelPopularidad;

    @ManyToOne
    @JoinColumn(name="id_piso")
    private Piso piso;
}
