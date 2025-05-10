package com.jcbs.carteira.core.model;

import java.time.LocalDateTime;


public class Usuario {

    private Long id;
    private String cpf;
    private String email;
    private String nome;
    private String senhaHash;
    private Boolean ativo = true;
    private LocalDateTime dataCriacao;

    public Usuario() {
    }

    public Usuario(Long id, String cpf, String email, String nome, String senhaHash, Boolean ativo,
            LocalDateTime dataCriacao) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senhaHash = senhaHash;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
}
