package com.jcbs.carteira.adapter.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.jcbs.carteira.adapter.persistence.jpa.mapper.TransacaoMapper;
import com.jcbs.carteira.adapter.persistence.jpa.model.TransacaoEntity;
import com.jcbs.carteira.domain.model.Transacao;
import com.jcbs.carteira.domain.repository.TransacaoRepository;

@Repository
public class TransacaoRepositoryJpaAdapter  implements TransacaoRepository {

    private TransacaoRepositoryJpa transacaoRepositoryJpa;

    public TransacaoRepositoryJpaAdapter(TransacaoRepositoryJpa transacaoRepositoryJpa) {
        this.transacaoRepositoryJpa = transacaoRepositoryJpa;
    }

    @Override
    public Transacao save(Transacao transacao) {
        TransacaoEntity transacaoEntity = TransacaoMapper.toEntity(transacao);
        TransacaoEntity savedEntity = transacaoRepositoryJpa.save(transacaoEntity);
        return TransacaoMapper.toModel(savedEntity);
    }

    @Override
    public Transacao findById(Long id) {
        TransacaoEntity transacaoEntity = transacaoRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transacao não encontrada com id: " + id));
        return TransacaoMapper.toModel(transacaoEntity);
    }

    @Override
    public void deleteById(Long id) {
        transacaoRepositoryJpa.deleteById(id);
    }
    
}
