package com.jcbs.carteira.core.repository;

import java.util.List;
import java.util.Optional;

import com.jcbs.carteira.core.model.Usuario;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    List<Usuario> findByNome(String nome);

    List<Usuario> findAll();

    void deleteById(Long id);
}
