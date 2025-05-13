package com.jcbs.carteira.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.infrastructure.model.TransacaoEntity;
@Repository
public interface TransacaoRepositoryJpa extends JpaRepository<TransacaoEntity, Long>{

}
