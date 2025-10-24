package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipos_obra")
public class TipoObra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoObra;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "tipoObra")
    private List<Obra> obras;
}
