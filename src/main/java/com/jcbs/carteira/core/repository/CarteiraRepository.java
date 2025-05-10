package com.jcbs.carteira.core.repository;

import java.util.List;
import java.util.Optional;

import com.jcbs.carteira.core.model.Carteira;

public interface CarteiraRepository {

    Optional<Carteira> findById(Long id);

    Carteira save(Carteira carteira);

    List<Carteira> findByUsuarioId(Long usuarioId);

    List<Carteira> findByUsuarioNome(String nome);

}
