package com.jcbs.usuariologincadastro.adapter.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.model.UsuarioEntity;

@Repository
public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Long> {
    
    UsuarioEntity findByNome(String nome);

    UsuarioEntity findByCpf(String cpf);

    UsuarioEntity findByEmail(String email);
 
}
