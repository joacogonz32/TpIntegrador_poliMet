package com.polimet.museo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_obra")
    private Obra obra;

    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer cantidadPersonas;

    @Enumerated(EnumType.STRING)
    private EstadoTicket estado;

    public LocalDate getFechaReserva() {return fechaReserva;}
    public void setFechaReserva(LocalDate fechaReserva) {this.fechaReserva = fechaReserva;}
    public LocalTime getHoraReserva() {return horaReserva;}
    public void setHoraReserva(LocalTime horaReserva) {this.horaReserva = horaReserva;}

    public enum EstadoTicket {
        ACTIVA, CANCELADA, VENCIDO
    }
}
