package com.jcbs.carteira.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcbs.carteira.core.model.Usuario;
import com.jcbs.carteira.infrastructure.persistence.UsuarioRepositoryImpl;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryImpl usuarioRepositoryImpl;

    public Optional<Usuario> findById(Long id) {
        return usuarioRepositoryImpl.findById(id);
    }

    public Usuario save(Usuario usuario) {
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setAtivo(true);
        return usuarioRepositoryImpl.save(usuario);
    }
}
