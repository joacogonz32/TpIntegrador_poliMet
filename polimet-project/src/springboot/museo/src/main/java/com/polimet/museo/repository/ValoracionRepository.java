package com.polimet.museo.repository;

import com.polimet.museo.model.Valoracion;
import com.polimet.museo.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByObra(Obra obra);
}
