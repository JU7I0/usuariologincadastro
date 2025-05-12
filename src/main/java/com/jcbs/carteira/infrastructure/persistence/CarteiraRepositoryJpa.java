package com.jcbs.carteira.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.infrastructure.model.CarteiraEntity;

import java.util.List;

@Repository
public interface CarteiraRepositoryJpa extends JpaRepository<CarteiraEntity, Long> {

    List<CarteiraEntity> findByUsuarioId(Long usuarioId);

    List<CarteiraEntity> findByUsuarioNome(String nome);
}
