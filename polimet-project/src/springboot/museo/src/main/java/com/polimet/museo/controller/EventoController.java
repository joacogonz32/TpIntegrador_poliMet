package com.polimet.museo.controller;

import com.polimet.museo.model.Evento;
import com.polimet.museo.service.EventoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> listarProximos(){
        return eventoService.listarEventosProximos();
    }
}
