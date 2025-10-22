package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "obras")
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObra;

    private String nombre;
    private String descripcion;
    private String epoca;
    private Float nivelPopularidad;

    @ManyToOne @JoinColumn(name = "id_artista")
    private Artista artista;

    @ManyToOne @JoinColumn(name = "id_sala")
    private Sala sala;
}
