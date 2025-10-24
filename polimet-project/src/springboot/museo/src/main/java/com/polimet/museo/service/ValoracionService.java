package com.polimet.museo.service;

import com.polimet.museo.model.Obra;
import com.polimet.museo.model.Valoracion;
import com.polimet.museo.repository.ObraRepository;
import com.polimet.museo.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    @Autowired
    private ObraRepository obraRepository;

    public Valoracion votar(Long idObra, Valoracion valoracion) {
        Obra obra = obraRepository.findById(idObra)
                .orElseThrow(() -> new RuntimeException("Obra no encontrada"));
        valoracion.setObra(obra);
        valoracion.setFecha(LocalDate.now());
        Valoracion guardada = valoracionRepository.save(valoracion);

        // Actualiza la popularidad promedio automáticamente
        List<Valoracion> valoraciones = valoracionRepository.findByObra_IdObra(idObra);
        float promedio = (float) valoraciones.stream().mapToInt(Valoracion::getPuntaje).average().orElse(0);
        obra.setNivelPopularidad(promedio);
        obraRepository.save(obra);

        return guardada;
    }

    public List<Valoracion> obtenerPorRango(LocalDate desde, LocalDate hasta) {
        return valoracionRepository.findByFechaBetween(desde, hasta);
    }
}
