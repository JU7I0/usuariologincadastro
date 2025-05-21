package com.jcbs.carteira.application.utils;

import com.jcbs.carteira.application.dto.UsuarioRequestDTO;
import com.jcbs.carteira.application.dto.UsuarioResponseDTO;
import com.jcbs.carteira.domain.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario mapToUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.cpf());
        usuario.setEmail(dto.email());
        usuario.setNome(dto.nome());
        usuario.setSenhaHash(dto.senha());
        return usuario;
    }

    public static UsuarioResponseDTO mapToUsuarioResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getCpf(),
            usuario.getEmail(),
            usuario.getNome(),
            usuario.getAtivo(),
            usuario.getDataCriacao()
        );
    }
}
