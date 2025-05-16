package com.jcbs.carteira.adapter.persistence.jpa.mapper;

import com.jcbs.carteira.adapter.persistence.jpa.model.CarteiraEntity;
import com.jcbs.carteira.domain.model.Carteira;

public class CarteiraMapper {

    private CarteiraMapper() {
    }

    public static Carteira toModel(CarteiraEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Carteira(
                entity.getId(),
                entity.getUsuario() != null ? UsuarioMapper.toModel(entity.getUsuario()) : null,
                entity.getSaldo(),
                entity.getLimiteDiario()
        );
    }

    public static CarteiraEntity toEntity(Carteira model) {
        if (model == null) {
            return null;
        }
        return new CarteiraEntity(
                model.getId(),
                UsuarioMapper.toEntity(model.getUsuario()),
                model.getSaldo(),
                model.getLimiteDiario()
        );
    }
}
