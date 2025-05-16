package com.jcbs.carteira.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jcbs.carteira.domain.model.Usuario;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    List<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();

    void deleteById(Long id);
}
