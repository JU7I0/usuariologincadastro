package com.jcbs.carteira.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcbs.carteira.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.carteira.application.utils.UsuarioValidador;
import com.jcbs.carteira.domain.model.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter;

    @Autowired
    private UsuarioValidador usuarioValidador;

    public Optional<Usuario> findById(Long id) {
        return usuarioRepositoryJpaAdapter.findById(id);
    }

    public Usuario save(Usuario usuario) {
        usuarioValidador.verificaUsuarioExistente(usuario);
        if (usuario.getId() == null) {
            usuario.setDataCriacao(LocalDateTime.now());
            usuario.setAtivo(true);
        }
        return usuarioRepositoryJpaAdapter.save(usuario);
    }

}
