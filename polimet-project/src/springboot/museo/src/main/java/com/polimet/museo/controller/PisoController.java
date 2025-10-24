package com.polimet.museo.controller;

import com.polimet.museo.model.Piso;
import com.polimet.museo.service.PisoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pisos")
public class PisoController {

    private final PisoService pisoService;

    public PisoController(PisoService pisoService){
        this.pisoService = pisoService;
    }

    @GetMapping
    public List<Piso> listar(){
        return pisoService.listarPisos();
    }
}
