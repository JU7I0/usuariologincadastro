package com.jcbs.usuariologincadastro.adapter.persistence.jpa.mapper;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.model.UsuarioEntity;
import com.jcbs.usuariologincadastro.domain.model.Usuario;

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
                entity.getDataCriacao(),
                entity.getRole()
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
                model.getDataCriacao(),
                model.getRole()
        );
    }

}
