package com.polimet.museo.service;

import com.polimet.museo.model.Piso;
import com.polimet.museo.repository.PisoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PisoService {

    private final PisoRepository pisoRepository;

    public PisoService(PisoRepository pisoRepository){
        this.pisoRepository = pisoRepository;
    }

    public List<Piso> listarPisos(){
        return pisoRepository.findAll();
    }
}
