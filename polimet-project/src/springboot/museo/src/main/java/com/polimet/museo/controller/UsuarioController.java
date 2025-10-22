package com.polimet.museo.controller;

import com.polimet.museo.model.Usuario;
import com.polimet.museo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }
}
