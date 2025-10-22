package com.polimet.museo.service;

import com.polimet.museo.model.Obra;
import com.polimet.museo.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    private final ObraRepository repo;

    public ObraService(ObraRepository repo) {
        this.repo = repo;
    }

    public List<Obra> filtrar(String epoca, String nombre) {
        return repo.findByEpocaContainingAndNombreContaining(epoca, nombre);
    }
}
