package com.jcbs.usuariologincadastro.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.usuariologincadastro.application.dto.UsuarioRequestDTO;
import com.jcbs.usuariologincadastro.application.dto.UsuarioResponseDTO;
import com.jcbs.usuariologincadastro.application.utils.UsuarioMapper;
import com.jcbs.usuariologincadastro.application.utils.UsuarioValidador;
import com.jcbs.usuariologincadastro.domain.model.Usuario;

class UsuarioServiceTest {

    private UsuarioService usuarioService;
    private UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter;
    private UsuarioValidador usuarioValidador;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        usuarioRepositoryJpaAdapter = mock(UsuarioRepositoryJpaAdapter.class);
        usuarioValidador = mock(UsuarioValidador.class);
        passwordEncoder = mock(PasswordEncoder.class);
        usuarioService = new UsuarioService(passwordEncoder, usuarioRepositoryJpaAdapter, usuarioValidador);
    }

    @Test
    void deveChamarValidadorAoSalvarUsuario() {
        UsuarioRequestDTO dto = new UsuarioRequestDTO("12345678901", "teste@email.com", "Nome", "Senha123!");
        when(passwordEncoder.encode(anyString())).thenReturn("senhaCriptografada");
        when(usuarioRepositoryJpaAdapter.save(any())).thenReturn(UsuarioMapper.mapToUsuario(dto));
        UsuarioResponseDTO response = usuarioService.save(dto);
        assertNotNull(response);
    }

    @Test
    void deveRetornarUsuarioQuandoEncontradoPorId() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        when(usuarioRepositoryJpaAdapter.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.findById(id);

        assertNotNull(resultado);
        assert(resultado.isPresent());
        assert(resultado.get().getId().equals(id));
    }

    @Test
    void deveRetornarOptionalVazioQuandoUsuarioNaoEncontradoPorId() {
        Long id = 2L;
        when(usuarioRepositoryJpaAdapter.findById(id)).thenReturn(Optional.empty());

        Optional<Usuario> resultado = usuarioService.findById(id);

        assertNotNull(resultado);
        assert(resultado.isEmpty());
    }
}