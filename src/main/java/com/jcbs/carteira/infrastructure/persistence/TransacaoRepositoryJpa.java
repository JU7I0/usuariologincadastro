package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcbs.carteira.core.model.Transacao;
import com.jcbs.carteira.core.repository.TransacaoRepository;

import jakarta.persistence.EntityManager;

@Repository
public class TransacaoRepositoryJpa implements TransacaoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Transacao> findByCarteiraId(Long carteiraId) {
        return entityManager.createQuery("SELECT t FROM Transacao t WHERE t.carteira.id = :carteiraId", Transacao.class)
                .setParameter("carteiraId", carteiraId)
                .getResultList();
    }

    @Override
    public Transacao save(Transacao transacao) {
        entityManager.persist(transacao);
        return transacao;
    }

    @Override
    public Transacao findById(Long id) {
        return entityManager.find(Transacao.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Transacao transacao = findById(id);
        if (transacao != null) {
            entityManager.remove(transacao);
        }   
    }
    
}
