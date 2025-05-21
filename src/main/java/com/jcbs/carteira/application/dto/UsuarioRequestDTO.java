package com.jcbs.carteira.application.dto;


public record UsuarioRequestDTO(
    String cpf,
    String email,
    String nome,
    String senha
) {}