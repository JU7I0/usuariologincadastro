package com.jcbs.usuariologincadastro.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.jcbs.usuariologincadastro.domain.model.Usuario;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    List<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmail(String email);

    UserDetails findByEmailDetails(String email);

    List<Usuario> findAll();

    void deleteById(Long id);
}
