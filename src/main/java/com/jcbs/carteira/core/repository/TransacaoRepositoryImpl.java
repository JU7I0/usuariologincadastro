package com.jcbs.carteira.core.repository;

import java.util.List;

import com.jcbs.carteira.core.model.Transacao;
import com.jcbs.carteira.infrastructure.persistence.TransacaoRepositoryJpa;

public class TransacaoRepositoryImpl  implements TransacaoRepository {

    private TransacaoRepositoryJpa transacaoRepositoryJpa;

    public TransacaoRepositoryImpl(TransacaoRepositoryJpa transacaoRepositoryJpa) {
        this.transacaoRepositoryJpa = transacaoRepositoryJpa;
    }

    @Override
    public List<Transacao> findByCarteiraId(Long carteiraId) {
        return transacaoRepositoryJpa.findByCarteiraId(carteiraId);
    }

    @Override
    public Transacao save(Transacao transacao) {
        return transacaoRepositoryJpa.save(transacao);
    }

    @Override
    public Transacao findById(Long id) {
        return transacaoRepositoryJpa.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        transacaoRepositoryJpa.deleteById(id);
    }
    
}
