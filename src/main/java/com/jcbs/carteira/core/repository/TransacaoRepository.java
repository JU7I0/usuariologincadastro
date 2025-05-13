package com.jcbs.carteira.core.repository;

import com.jcbs.carteira.core.model.Transacao;

public interface TransacaoRepository {

    Transacao save(Transacao transacao);

    Transacao findById(Long id);

    void deleteById(Long id);
}
