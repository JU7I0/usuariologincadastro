package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Usuario;
import com.jcbs.carteira.core.repository.UsuarioRepository;

import jakarta.persistence.EntityManager;

@Repository
public class UsuarioRepositoryJpa implements UsuarioRepository {
    

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Usuario.class, id));
    }
    
    @Override
    public Usuario save(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }
    
    @Override
    public List<Usuario> findByNome(String nome) {
        return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    
    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
    
    @Override
    public void deleteById(Long id) {
        Optional<Usuario> optionalUsuario = findById(id);
        optionalUsuario.ifPresent(entityManager::remove);
    }
}
