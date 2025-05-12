package com.jcbs.carteira.infrastructure.persistence;

import java.util.List;

import com.jcbs.carteira.core.model.Transacao;
import com.jcbs.carteira.core.repository.TransacaoRepository;
import com.jcbs.carteira.infrastructure.mapper.TransacaoMapper;
import com.jcbs.carteira.infrastructure.model.TransacaoEntity;

public class TransacaoRepositoryImpl  implements TransacaoRepository {

    private TransacaoRepositoryJpa transacaoRepositoryJpa;

    public TransacaoRepositoryImpl(TransacaoRepositoryJpa transacaoRepositoryJpa) {
        this.transacaoRepositoryJpa = transacaoRepositoryJpa;
    }

    @Override
    public List<Transacao> findByCarteiraId(Long carteiraId) {
        List<TransacaoEntity> transacaoEntity = transacaoRepositoryJpa.findByCarteiraId(carteiraId);
        if (transacaoEntity != null) {
            return transacaoEntity.stream()
                                   .map(TransacaoMapper::toModel)
                                   .toList();
        }
        return List.of();
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
