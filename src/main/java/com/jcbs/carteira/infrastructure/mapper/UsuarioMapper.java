package com.jcbs.carteira.infrastructure.mapper;

import com.jcbs.carteira.core.model.Usuario;
import com.jcbs.carteira.infrastructure.model.UsuarioEntity;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario toModel(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Usuario(
                entity.getId(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getNome(),
                entity.getSenhaHash(),
                entity.getAtivo(),
                entity.getDataCriacao()
        );
    }

    public static UsuarioEntity toEntity(Usuario model) {
        if (model == null) {
            return null;
        }
        return new UsuarioEntity(
                model.getId(),
                model.getCpf(),
                model.getEmail(),
                model.getNome(),
                model.getSenhaHash(),
                model.getAtivo(),
                model.getDataCriacao()
        );
    }

}
