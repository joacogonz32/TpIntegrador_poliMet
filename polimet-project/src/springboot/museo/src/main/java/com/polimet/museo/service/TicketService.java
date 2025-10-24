package com.polimet.museo.service;

import com.polimet.museo.model.Ticket;
import com.polimet.museo.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket reservar(Ticket ticket){
        // Verificación de disponibilidad llamando a procedimiento SQL
        List<Ticket> existentes = ticketRepository.findByFechaReservaAndHoraReserva(ticket.getFechaReserva(), ticket.getHoraReserva());
        if(!existentes.isEmpty()){
            throw new RuntimeException("No hay disponibilidad para esa fecha y hora");
        }
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarTickets(){
        return ticketRepository.findAll();
    }
}
