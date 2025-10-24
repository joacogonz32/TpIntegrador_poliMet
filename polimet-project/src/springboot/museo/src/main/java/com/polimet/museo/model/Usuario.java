package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String email;
    private String pais;
    private String telefono;
    private String password;

    @Column(name="fecha_nacimiento")
    private java.sql.Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name="id_membresia")
    private Membresia membresia;

    @OneToMany(mappedBy = "usuario")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "usuario")
    private List<Valoracion> valoraciones;

    @OneToMany(mappedBy = "usuario")
    private List<Visita> visitas;

    @OneToMany(mappedBy = "usuario")
    private List<Notificacion> notificaciones;

    @ManyToMany
    @JoinTable(
            name = "usuarios_eventos",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_evento")
    )
    private List<Evento> eventos;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
