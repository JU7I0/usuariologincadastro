package com.jcbs.carteira.application.utils;

import com.jcbs.carteira.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.carteira.domain.model.Usuario;

public class UsuarioValidador {

    private final UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter;

    public UsuarioValidador(UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter) {
        this.usuarioRepositoryJpaAdapter = usuarioRepositoryJpaAdapter;
    }

    public void verificaUsuarioExistente(Usuario usuario) {
        if (usuarioRepositoryJpaAdapter.findByCpf(usuario.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado, por favor, verifique se sua conta está ativa!");
        }
        if (usuarioRepositoryJpaAdapter.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado, por favor, verifique se sua conta está ativa!");
        }
    }

}
