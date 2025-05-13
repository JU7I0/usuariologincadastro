package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jcbs.carteira.infrastructure.mapper.CarteiraMapper;


import com.jcbs.carteira.core.model.Carteira;
import com.jcbs.carteira.core.repository.CarteiraRepository;
import com.jcbs.carteira.infrastructure.model.CarteiraEntity;
@Repository
public class CarteiraRepositoryImpl implements CarteiraRepository {

    private CarteiraRepositoryJpa carteiraRepositoryJpa;

    public CarteiraRepositoryImpl(CarteiraRepositoryJpa carteiraRepositoryJpa) {
        this.carteiraRepositoryJpa = carteiraRepositoryJpa;
    }

    @Override
    public Optional<Carteira> findById(Long id) {
        CarteiraEntity carteiraEntity = carteiraRepositoryJpa.findById(id).orElse(null);
        if (carteiraEntity != null) {
            return Optional.of(CarteiraMapper.toModel(carteiraEntity));
        }
        return Optional.empty();
    }

    @Override
    public Carteira save(Carteira carteira) {
        CarteiraEntity carteiraEntity = CarteiraMapper.toEntity(carteira);
        CarteiraEntity savedEntity = carteiraRepositoryJpa.save(carteiraEntity);
        return CarteiraMapper.toModel(savedEntity);
    }

    @Override
    public List<Carteira> findByUsuarioId(Long usuarioId) {
        List<CarteiraEntity> carteiraEntities = carteiraRepositoryJpa.findByUsuarioId(usuarioId);
        return carteiraEntities.stream()
                .map(CarteiraMapper::toModel)
                .toList();
    }

    @Override
    public List<Carteira> findByUsuarioNome(String nome) {
        List<CarteiraEntity> carteiraEntities = carteiraRepositoryJpa.findByUsuarioNome(nome);
        return carteiraEntities.stream()
                .map(CarteiraMapper::toModel)
                .toList();
    }
    
}
