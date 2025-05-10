package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Carteira;
import com.jcbs.carteira.core.repository.CarteiraRepository;

import jakarta.persistence.EntityManager;

@Repository
public class CarteiraRepositoryJpa implements CarteiraRepository {
    
 
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Optional<Carteira> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Carteira.class, id));
    }
    
    @Override
    public Carteira save(Carteira carteira) {
        entityManager.persist(carteira);
        return carteira;
    }
    
    @Override
    public List<Carteira> findByUsuarioId(Long usuarioId) {
        return entityManager.createQuery("SELECT c FROM Carteira c WHERE c.usuario.id = :usuarioId", Carteira.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }
    
    @Override
    public List<Carteira> findByUsuarioNome(String nome) {
        return entityManager.createQuery("SELECT c FROM Carteira c WHERE c.usuario.nome = :nome", Carteira.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
