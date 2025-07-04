package com.jcbs.usuariologincadastro.application.dto;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
    Long id,
    String cpf,
    String email,
    String nome,
    Boolean ativo,
    LocalDateTime dataCriacao
) {}
