package com.jcbs.carteira.adapter.persistence.jpa.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal valor;

    @Column(name = "origem_id")
    private Long origemId;

    @Column(name = "destino_id")
    private Long destinoId;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;


    public TransacaoEntity() {
    }

    public TransacaoEntity(Long id, String tipo, BigDecimal valor, Long origemId, Long destinoId, String status, LocalDateTime dataCriacao) {
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