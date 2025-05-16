package com.jcbs.carteira.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jcbs.carteira.domain.model.Carteira;

public interface CarteiraRepository {

    Optional<Carteira> findById(Long id);

    Carteira save(Carteira carteira);

    List<Carteira> findByUsuarioId(Long usuarioId);

    List<Carteira> findByUsuarioNome(String nome);

}
