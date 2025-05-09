package com.jcbs.carteira.core.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal valor;

    @Column(name = "origem_id")
    private UUID origemId;

    @Column(name = "destino_id")
    private UUID destinoId;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;


    public Transacao() {
    }

    public Transacao(UUID id, String tipo, BigDecimal valor, UUID origemId, UUID destinoId, String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.origemId = origemId;
        this.destinoId = destinoId;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public UUID getOrigemId() {
        return origemId;
    }

    public void setOrigemId(UUID origemId) {
        this.origemId = origemId;
    }

    public UUID getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(UUID destinoId) {
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