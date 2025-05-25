package com.jcbs.usuariologincadastro.adapter.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.mapper.UsuarioMapper;
import com.jcbs.usuariologincadastro.adapter.persistence.jpa.model.UsuarioEntity;
import com.jcbs.usuariologincadastro.domain.model.Usuario;
import com.jcbs.usuariologincadastro.domain.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryJpaAdapter implements UsuarioRepository {

    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryJpaAdapter(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepositoryJpa.findById(id);
        if (usuarioEntity.isPresent()) {
            return usuarioEntity.map(UsuarioMapper::toModel);
        }
        return Optional.empty();
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity savedEntity = usuarioRepositoryJpa.save(usuarioEntity);
        return UsuarioMapper.toModel(savedEntity);
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByNome(nome);
        return List.of(UsuarioMapper.toModel(usuarioEntity));
    }

    @Override
    public Optional<Usuario> findByCpf(String cpf) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByCpf(cpf);
        return Optional.ofNullable(UsuarioMapper.toModel(usuarioEntity));
    }

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> usuarioEntities = usuarioRepositoryJpa.findAll();
        return usuarioEntities.stream()
                              .map(UsuarioMapper::toModel)
                              .toList();
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepositoryJpa.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByEmail(email);
        return Optional.ofNullable(UsuarioMapper.toModel(usuarioEntity));
    }

    @Override
    public UserDetails findByEmailDetails(String email) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                usuarioEntity.getEmail(),
                usuarioEntity.getSenhaHash(),
                usuarioEntity.getAuthorities()
        );
    }

}
