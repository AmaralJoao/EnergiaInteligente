package com.br.EnergiaInteligente.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdUsuario")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "dtCriacao")
    private LocalDateTime dataCriacao;

    @Column(name = "dtAtualizacao")
    private LocalDateTime atualizacao;

    @Column(name = "nmUsuario")
    private String nomeDoUsuario;

    @Column(name = "nmDeUsuario")
    private String nomeDeUsuario;

    @Column(name = "contato")
    private String contato;

    @Column(name = "dtNascimento")
    private LocalDateTime dataNascimento;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nomeDoUsuario, String email, String contato, LocalDateTime dataNascimento, String nomeDeUsuario) {
        this.id = id;
        this.nomeDoUsuario = nomeDoUsuario;
        this.email = email;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public UsuarioModel(Long id, String senha, LocalDateTime dataCriacao, LocalDateTime atualizacao, String nomeDoUsuario, String email, String contato, LocalDateTime dataNascimento) {
        this.id = id;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.atualizacao = atualizacao;
        this.nomeDoUsuario = nomeDoUsuario;
        this.email = email;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }
}
