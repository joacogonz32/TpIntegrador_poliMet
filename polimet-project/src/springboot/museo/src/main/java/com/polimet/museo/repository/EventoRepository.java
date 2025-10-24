package com.polimet.museo.repository;

import com.polimet.museo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByFechaInicioAfter(LocalDateTime now);
}
