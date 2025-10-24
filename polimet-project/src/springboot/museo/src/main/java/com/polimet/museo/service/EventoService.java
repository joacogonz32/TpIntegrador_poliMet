package com.polimet.museo.service;

import com.polimet.museo.model.Evento;
import com.polimet.museo.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> listarEventosProximos(){
        return eventoRepository.findByFechaInicioAfter(LocalDateTime.now());
    }
}
