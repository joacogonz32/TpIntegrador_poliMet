package com.polimet.museo.repository;

import com.polimet.museo.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    List<Obra> findByNombreContainingIgnoreCase(String nombre);

    List<Obra> findByEpocaContainingAndNombreContaining(String epoca, String nombre);
}
