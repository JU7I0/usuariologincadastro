package com.jcbs.carteira.core.repository;

import java.util.List;
import java.util.Optional;

import com.jcbs.carteira.core.model.Usuario;
import com.jcbs.carteira.infrastructure.persistence.UsuarioRepositoryJpa;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepositoryJpa.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositoryJpa.save(usuario);
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        return usuarioRepositoryJpa.findByNome(nome);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositoryJpa.findAll();
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepositoryJpa.deleteById(id);
    }

}
