package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Transacao;
import jakarta.persistence.EntityManager;

@Repository
public class TransacaoRepositoryJpa {

    @Autowired
    private EntityManager entityManager;

    public List<Transacao> findByCarteiraId(Long carteiraId) {
        return entityManager.createQuery("SELECT t FROM Transacao t WHERE t.carteira.id = :carteiraId", Transacao.class)
                .setParameter("carteiraId", carteiraId)
                .getResultList();
    }

    public Transacao save(Transacao transacao) {
        entityManager.persist(transacao);
        return transacao;
    }

    public Transacao findById(Long id) {
        return entityManager.find(Transacao.class, id);
    }

    public void deleteById(Long id) {
        Transacao transacao = findById(id);
        if (transacao != null) {
            entityManager.remove(transacao);
        }   
    }
    
}
