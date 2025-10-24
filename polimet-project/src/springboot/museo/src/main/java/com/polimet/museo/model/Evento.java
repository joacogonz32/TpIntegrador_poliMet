package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Integer capacidad;

    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios;
}
