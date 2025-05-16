package com.jcbs.carteira.adapter.persistence.jpa.mapper;

import com.jcbs.carteira.adapter.persistence.jpa.model.TransacaoEntity;
import com.jcbs.carteira.domain.model.Transacao;

public class TransacaoMapper {

        private TransacaoMapper() {
    }

    public static Transacao toModel(TransacaoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Transacao(
                entity.getId(),
                entity.getTipo(),
                entity.getValor(),
                entity.getOrigemId(),
                entity.getDestinoId(),
                entity.getStatus(),
                entity.getDataCriacao()
        );
    }

    public static TransacaoEntity toEntity(Transacao model) {
        if (model == null) {
            return null;
        }
        return new TransacaoEntity(
                model.getId(),
                model.getTipo(),
                model.getValor(),
                model.getOrigemId(),
                model.getDestinoId(),
                model.getStatus(),
                model.getDataCriacao()
        );
    }
}
