package com.jcbs.carteira.core.repository;

import java.util.List;

import com.jcbs.carteira.core.model.Transacao;

public interface TransacaoRepository {

    List<Transacao> findByCarteiraId(Long carteiraId);

    Transacao save(Transacao transacao);

    Transacao findById(Long id);

    void deleteById(Long id);
}
