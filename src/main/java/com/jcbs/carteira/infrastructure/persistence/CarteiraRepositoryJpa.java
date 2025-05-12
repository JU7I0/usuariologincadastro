package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Carteira;

import jakarta.persistence.EntityManager;

@Repository
public class CarteiraRepositoryJpa {
 
    @Autowired
    private EntityManager entityManager;
    
    public Optional<Carteira> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Carteira.class, id));
    }
    
    public Carteira save(Carteira carteira) {
        entityManager.persist(carteira);
        return carteira;
    }
    
    public List<Carteira> findByUsuarioId(Long usuarioId) {
        return entityManager.createQuery("SELECT c FROM Carteira c WHERE c.usuario.id = :usuarioId", Carteira.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }
    
    public List<Carteira> findByUsuarioNome(String nome) {
        return entityManager.createQuery("SELECT c FROM Carteira c WHERE c.usuario.nome = :nome", Carteira.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
