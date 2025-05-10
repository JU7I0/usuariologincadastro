package com.jcbs.carteira.core.model;

import java.math.BigDecimal;

public class Carteira {

    private Long id;
    private Usuario usuario;
    private BigDecimal saldo;
    private BigDecimal limiteDiario;

    public Carteira() {
    }

    public Carteira(Long id, Usuario usuario, BigDecimal saldo, BigDecimal limiteDiario) {
        this.id = id;
        this.usuario = usuario;
        this.saldo = saldo;
        this.limiteDiario = limiteDiario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(BigDecimal limiteDiario) {
        this.limiteDiario = limiteDiario;
    }
}