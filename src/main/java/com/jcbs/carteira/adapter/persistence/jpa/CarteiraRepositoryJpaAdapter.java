package com.jcbs.carteira.adapter.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jcbs.carteira.adapter.persistence.jpa.mapper.CarteiraMapper;
import com.jcbs.carteira.adapter.persistence.jpa.model.CarteiraEntity;
import com.jcbs.carteira.domain.model.Carteira;
import com.jcbs.carteira.domain.repository.CarteiraRepository;
@Repository
public class CarteiraRepositoryJpaAdapter implements CarteiraRepository {

    private CarteiraRepositoryJpa carteiraRepositoryJpa;

    public CarteiraRepositoryJpaAdapter(CarteiraRepositoryJpa carteiraRepositoryJpa) {
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
