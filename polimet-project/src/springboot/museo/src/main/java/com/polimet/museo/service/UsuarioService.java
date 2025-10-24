package com.polimet.museo.service;

import com.polimet.museo.model.Usuario;
import com.polimet.museo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> login(String email, String password){
        return usuarioRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password));
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
