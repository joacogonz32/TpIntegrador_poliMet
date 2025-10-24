package com.polimet.museo.controller;

import com.polimet.museo.model.Obra;
import com.polimet.museo.service.ObraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService){
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> listar(@RequestParam(required = false) String nombre){
        if(nombre != null) return obraService.filtrarPorNombre(nombre);
        return obraService.listarObras();
    }

    @GetMapping("/{id}")
    public Obra obtener(@PathVariable Long id){
        return obraService.obtenerPorId(id);
    }
}
