package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="membresias")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembresia;

    private String tipo;

    private String descripcion;

    @OneToMany(mappedBy = "membresia")
    private List<Usuario> usuarios;
}
