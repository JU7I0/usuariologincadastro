package com.jcbs.carteira.core.repository;

import java.util.List;
import java.util.Optional;


import com.jcbs.carteira.core.model.Carteira;
import com.jcbs.carteira.infrastructure.persistence.CarteiraRepositoryJpa;

public class CarteiraRepositoryImpl implements CarteiraRepository {

    private CarteiraRepositoryJpa carteiraRepositoryJpa;

    public CarteiraRepositoryImpl(CarteiraRepositoryJpa carteiraRepositoryJpa) {
        this.carteiraRepositoryJpa = carteiraRepositoryJpa;
    }

    @Override
    public Optional<Carteira> findById(Long id) {
        return carteiraRepositoryJpa.findById(id);
    }

    @Override
    public Carteira save(Carteira carteira) {
        return carteiraRepositoryJpa.save(carteira);
    }

    @Override
    public List<Carteira> findByUsuarioId(Long usuarioId) {
        return carteiraRepositoryJpa.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Carteira> findByUsuarioNome(String nome) {
        return carteiraRepositoryJpa.findByUsuarioNome(nome);
    }
    
}
