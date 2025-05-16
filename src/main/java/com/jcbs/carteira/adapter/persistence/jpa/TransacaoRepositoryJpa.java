package com.jcbs.carteira.adapter.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.adapter.persistence.jpa.model.TransacaoEntity;
@Repository
public interface TransacaoRepositoryJpa extends JpaRepository<TransacaoEntity, Long>{

}
