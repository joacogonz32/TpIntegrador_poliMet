package com.polimet.museo.repository;

import com.polimet.museo.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {

    List<Obra> findBySala_Piso_Nombre(String piso);

    List<Obra> findByEpocaContainingIgnoreCase(String epoca);

    List<Obra> findByNombreContainingIgnoreCase(String nombre);

    List<Obra> findByNivelPopularidadGreaterThanEqual(Float valor);
}
