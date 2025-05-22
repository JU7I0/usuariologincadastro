package com.jcbs.carteira.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jcbs.carteira.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.carteira.application.dto.UsuarioRequestDTO;
import com.jcbs.carteira.application.dto.UsuarioResponseDTO;
import com.jcbs.carteira.application.utils.UsuarioMapper;
import com.jcbs.carteira.application.utils.UsuarioValidador;
import com.jcbs.carteira.domain.model.Usuario;

@Service
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter;
    private final UsuarioValidador usuarioValidador;

    public UsuarioService(PasswordEncoder passwordEncoder,
                          UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter,
                          UsuarioValidador usuarioValidador) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepositoryJpaAdapter = usuarioRepositoryJpaAdapter;
        this.usuarioValidador = usuarioValidador;
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepositoryJpaAdapter.findById(id);
    }

    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        usuarioValidador.verificaUsuarioRequestDTO(usuarioRequestDTO);
        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioRequestDTO);
        usuarioValidador.verificaUsuarioExistente(usuario);
        usuario.setSenhaHash(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        if (usuario.getId() == null) {
            usuario.setDataCriacao(LocalDateTime.now());
            usuario.setAtivo(true);
        }
        Usuario usuarioSalvo = usuarioRepositoryJpaAdapter.save(usuario);
        return UsuarioMapper.mapToUsuarioResponseDTO(usuarioSalvo);
    }

}
