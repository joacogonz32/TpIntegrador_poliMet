package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="obras")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObra;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String epoca;

    @Column(name="nivel_popularidad")
    private Float nivelPopularidad;

    @ManyToOne
    @JoinColumn(name="id_artista")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name="id_sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name="id_tipo_obra")
    private TipoObra tipoObra;

    @OneToMany(mappedBy = "obra")
    private List<Valoracion> valoraciones;

    @OneToMany(mappedBy = "obra")
    private List<Visita> visitas;

    @OneToMany(mappedBy = "obra")
    private List<Ticket> tickets;

    public Obra(Long idObra, String nombre, String descripcion, String epoca, Float nivelPopularidad, Artista artista, Sala sala, TipoObra tipoObra, List<Valoracion> valoraciones, List<Visita> visitas, List<Ticket> tickets) {
        this.idObra = idObra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.epoca = epoca;
        this.nivelPopularidad = nivelPopularidad;
        this.artista = artista;
        this.sala = sala;
        this.tipoObra = tipoObra;
        this.valoraciones = valoraciones;
        this.visitas = visitas;
        this.tickets = tickets;
    }

    public Obra(Long idObra, Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
    }
}
