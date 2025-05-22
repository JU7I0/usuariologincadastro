package com.jcbs.carteira.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class UsuarioRequestDTO {

    private String cpf;
    private String email;
    private String nome;
    private String senha;
}