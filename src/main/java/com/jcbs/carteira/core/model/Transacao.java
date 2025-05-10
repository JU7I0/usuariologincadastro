package com.jcbs.carteira.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private Long id;
    private String tipo;
    private BigDecimal valor;
    private Long origemId;
    private Long destinoId;
    private String status;
    private LocalDateTime dataCriacao;


    public Transacao() {
    }

    public Transacao(Long id, String tipo, BigDecimal valor, Long origemId, Long destinoId, String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.origemId = origemId;
        this.destinoId = destinoId;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getOrigemId() {
        return origemId;
    }

    public void setOrigemId(Long origemId) {
        this.origemId = origemId;
    }

    public Long getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Long destinoId) {
        this.destinoId = destinoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}