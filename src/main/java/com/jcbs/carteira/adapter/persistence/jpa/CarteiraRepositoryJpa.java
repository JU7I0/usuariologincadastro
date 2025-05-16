package com.jcbs.carteira.adapter.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.adapter.persistence.jpa.model.CarteiraEntity;

import java.util.List;

@Repository
public interface CarteiraRepositoryJpa extends JpaRepository<CarteiraEntity, Long> {

    List<CarteiraEntity> findByUsuarioId(Long usuarioId);

    List<CarteiraEntity> findByUsuarioNome(String nome);
}
