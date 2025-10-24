package com.polimet.museo.service;

import com.polimet.museo.model.Obra;
import com.polimet.museo.repository.ObraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository){
        this.obraRepository = obraRepository;
    }

    public List<Obra> listarObras(){
        return obraRepository.findAll();
    }

    public Obra obtenerPorId(Long id){
        return obraRepository.findById(id).orElse(null);
    }

    public List<Obra> filtrarPorNombre(String nombre){
        return obraRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
