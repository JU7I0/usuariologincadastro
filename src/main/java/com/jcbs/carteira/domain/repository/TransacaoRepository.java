package com.jcbs.carteira.domain.repository;

import com.jcbs.carteira.domain.model.Transacao;

public interface TransacaoRepository {

    Transacao save(Transacao transacao);

    Transacao findById(Long id);

    void deleteById(Long id);
}
