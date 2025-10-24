package com.polimet.museo.repository;

import com.polimet.museo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByUsuario_IdUsuario(Long idUsuario);

    List<Ticket> findByFechaReserva(LocalDate fecha);

    boolean existsByFechaReservaAndHoraReservaAndEstado(LocalDate fecha, java.time.LocalTime hora, Ticket.EstadoTicket estado);
}
