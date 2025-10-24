package com.polimet.museo.repository;

import com.polimet.museo.model.Obra;
import com.polimet.museo.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

    List<Valoracion> findByObra_IdObra(Long idObra);

    List<Valoracion> findByFechaBetween(LocalDate desde, LocalDate hasta);

    List<Valoracion> findByObra(Obra obra);
}
