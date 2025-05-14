package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Usuario;
import com.jcbs.carteira.core.repository.UsuarioRepository;
import com.jcbs.carteira.infrastructure.mapper.UsuarioMapper;
import com.jcbs.carteira.infrastructure.model.UsuarioEntity;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
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
    public Usuario findByCpf(String cpf) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByCpf(cpf);
        return UsuarioMapper.toModel(usuarioEntity);
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
    public Usuario findByEmail(String email) {
        UsuarioEntity usuarioEntity = usuarioRepositoryJpa.findByEmail(email);
        return UsuarioMapper.toModel(usuarioEntity);
    }

}
