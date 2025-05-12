package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Usuario;

import jakarta.persistence.EntityManager;

@Repository
public class UsuarioRepositoryJpa {
    
    @Autowired
    private EntityManager entityManager;

    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Usuario.class, id));
    }   

    public Usuario save(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    public List<Usuario> findByNome(String nome) {
        return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                .setParameter("nome", nome)
                .getResultList();
    }    

    public List<Usuario> findAll() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
    
    public void deleteById(Long id) {
        Optional<Usuario> optionalUsuario = findById(id);
        optionalUsuario.ifPresent(entityManager::remove);
    }
}
