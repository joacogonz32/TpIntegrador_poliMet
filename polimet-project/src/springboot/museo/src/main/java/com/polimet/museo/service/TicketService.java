package com.polimet.museo.service;

import com.polimet.museo.model.Ticket;
import com.polimet.museo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Reserva un ticket verificando disponibilidad para la misma fecha/hora.
     * Lanza RuntimeException si ya existe una reserva activa en esa fecha/hora.
     */
    public Ticket reservar(Ticket ticket) {
        boolean ocupado = ticketRepository.existsByFechaReservaAndHoraReservaAndEstado(
                ticket.getFechaReserva(), ticket.getHoraReserva(), Ticket.EstadoTicket.ACTIVA
        );
        if (ocupado) {
            throw new RuntimeException("No hay disponibilidad para esa fecha y hora");
        }
        ticket.setEstado(Ticket.EstadoTicket.ACTIVA);
        return ticketRepository.save(ticket);
    }

    /**
     * Lista todos los tickets en la base de datos.
     */
    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    /**
     * Lista tickets por usuario (idUsuario).
     */
    public List<Ticket> listarPorUsuario(Long idUsuario) {
        return ticketRepository.findByUsuario_IdUsuario(idUsuario);
    }

    /**
     * Lista tickets por fecha de reserva.
     */
    public List<Ticket> listarPorFecha(LocalDate fecha) {
        return ticketRepository.findByFechaReserva(fecha);
    }

    /**
     * Cancela un ticket (cambia estado a CANCELADA).
     */
    public Ticket cancelarTicket(Long idTicket) {
        Optional<Ticket> opt = ticketRepository.findById(idTicket);
        if (opt.isEmpty()) {
            throw new RuntimeException("Ticket no encontrado");
        }
        Ticket t = opt.get();
        t.setEstado(Ticket.EstadoTicket.CANCELADA);
        return ticketRepository.save(t);
    }
}
