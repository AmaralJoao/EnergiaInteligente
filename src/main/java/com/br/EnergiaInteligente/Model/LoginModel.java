package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "login")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdLogin")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "dtCriacao")
    private LocalDateTime dataCriacao;

    @Column(name = "dtAtualizacao")
    private LocalDateTime atualizacao;

    public LoginModel() {
    }

    public LoginModel(long id, String login, String senha, LocalDateTime dataCriacao, LocalDateTime atualizacao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.atualizacao = atualizacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(LocalDateTime atualizacao) {
        this.atualizacao = atualizacao;
    }
}
