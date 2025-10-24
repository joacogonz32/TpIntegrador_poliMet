package com.polimet.museo.controller;

import com.polimet.museo.model.Obra;
import com.polimet.museo.service.ObraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    private final ObraService obraService;

    public EstadisticaController(ObraService obraService){
        this.obraService = obraService;
    }

    @GetMapping("/top-obras")
    public List<Obra> topObras(@RequestParam String desde, @RequestParam String hasta){
        // Aquí se podría llamar a un procedimiento SQL que ya existe en la DB
        // Para simplificar devolvemos todas las obras (en un proyecto real, se ejecutaría procedimiento con @Procedure)
        return obraService.listarObras();
    }
}
