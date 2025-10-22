package com.polimet.museo.controller;

import com.polimet.museo.model.Obra;
import com.polimet.museo.service.ObraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {
    private final ObraService service;

    public ObraController(ObraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Obra> filtrar(
            @RequestParam(defaultValue = "") String epoca,
            @RequestParam(defaultValue = "") String nombre
    ) {
        return service.filtrar(epoca, nombre);
    }
}
