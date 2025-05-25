package com.jcbs.usuariologincadastro.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.jcbs.usuariologincadastro.adapter.persistence.jpa.UsuarioRepositoryJpa;
import com.jcbs.usuariologincadastro.adapter.persistence.jpa.model.UsuarioEntity;


class AuthorizationServiceTest {

    private AuthorizationService authorizationService;
    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    @BeforeEach
    void setUp() {
        usuarioRepositoryJpa = mock(UsuarioRepositoryJpa.class);
        authorizationService = new AuthorizationService();
        authorizationService.repository = usuarioRepositoryJpa;
    }

    @Test
    void deveRetornarUserDetailsQuandoUsuarioExiste() {
        String email = "usuario@email.com";
        UsuarioEntity usuarioEntity = mock(UsuarioEntity.class);
        when(usuarioRepositoryJpa.findByEmail(email)).thenReturn(usuarioEntity);

        UserDetails result = authorizationService.loadUserByUsername(email);

        assertNotNull(result);
    }

    @Test
    void deveLancarUsernameNotFoundExceptionQuandoUsuarioNaoExiste() {
        String email = "naoexiste@email.com";
        when(usuarioRepositoryJpa.findByEmail(email)).thenThrow(new UsernameNotFoundException("Usuário não encontrado"));

        assertThrows(UsernameNotFoundException.class, () -> {
            authorizationService.loadUserByUsername(email);
        });
    }
}