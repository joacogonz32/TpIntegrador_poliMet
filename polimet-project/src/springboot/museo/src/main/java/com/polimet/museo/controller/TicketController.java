package com.polimet.museo.controller;

import com.polimet.museo.model.Ticket;
import com.polimet.museo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * Endpoint principal para reservar tickets.
     * POST /api/tickets/reservar
     */
    @PostMapping("/reservar")
    public Ticket reservar(@RequestBody Ticket ticket) {
        return ticketService.reservar(ticket);
    }

    // --- OPCIONALES / para pruebas o admin ---

    /**
     * GET /api/tickets → lista todos los tickets
     */
    @GetMapping
    public List<Ticket> listar() {
        return ticketService.listarTickets();
    }

    /**
     * DELETE /api/tickets/{id}/cancelar → cancela un ticket
     */
    @DeleteMapping("/{id}/cancelar")
    public Ticket cancelar(@PathVariable Long id) {
        return ticketService.cancelarTicket(id);
    }
}
