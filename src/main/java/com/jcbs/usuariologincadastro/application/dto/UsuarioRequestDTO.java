package com.jcbs.usuariologincadastro.application.dto;

public record UsuarioRequestDTO(
    String cpf,
    String email,
    String nome,
    String senha
) {}
