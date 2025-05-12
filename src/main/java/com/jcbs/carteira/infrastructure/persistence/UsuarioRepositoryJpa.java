package com.jcbs.carteira.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.infrastructure.model.UsuarioEntity;

@Repository
public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Long> {
    
    UsuarioEntity findByNome(String nome);
 
}
