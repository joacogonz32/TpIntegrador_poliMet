package com.polimet.museo.repository;

import com.polimet.museo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByFechaReservaAndHoraReserva(LocalDate fecha, LocalTime hora);
}
