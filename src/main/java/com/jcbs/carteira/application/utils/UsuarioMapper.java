package com.jcbs.carteira.application.utils;

import com.jcbs.carteira.application.dto.UsuarioRequestDTO;
import com.jcbs.carteira.application.dto.UsuarioResponseDTO;
import com.jcbs.carteira.domain.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario mapToUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenhaHash(dto.getSenha());
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
