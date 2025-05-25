package com.jcbs.usuariologincadastro.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.usuariologincadastro.application.dto.UsuarioRequestDTO;
import com.jcbs.usuariologincadastro.application.dto.UsuarioResponseDTO;
import com.jcbs.usuariologincadastro.application.utils.UsuarioMapper;
import com.jcbs.usuariologincadastro.application.utils.UsuarioValidador;
import com.jcbs.usuariologincadastro.domain.model.Usuario;

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
        usuario.setSenhaHash(passwordEncoder.encode(usuarioRequestDTO.senha()));
        
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setAtivo(true);
        
        Usuario usuarioSalvo = usuarioRepositoryJpaAdapter.save(usuario);
        return UsuarioMapper.mapToUsuarioResponseDTO(usuarioSalvo);
    }

}
