package com.polimet.museo.service;

import com.polimet.museo.model.Valoracion;
import com.polimet.museo.repository.ValoracionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValoracionService {

    private final ValoracionRepository valoracionRepository;

    public ValoracionService(ValoracionRepository valoracionRepository){
        this.valoracionRepository = valoracionRepository;
    }

    public Valoracion votar(Valoracion valoracion){
        return valoracionRepository.save(valoracion);
    }

    public List<Valoracion> listarPorObraId(Long idObra){
        return valoracionRepository.findByObra(new com.polimet.museo.model.Obra(idObra, null, null, null, null, null, null, null, null));
    }
}
