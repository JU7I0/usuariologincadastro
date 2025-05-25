package com.jcbs.usuariologincadastro.application.utils;

import com.jcbs.usuariologincadastro.application.dto.UsuarioRequestDTO;
import com.jcbs.usuariologincadastro.application.dto.UsuarioResponseDTO;
import com.jcbs.usuariologincadastro.domain.model.Usuario;

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
