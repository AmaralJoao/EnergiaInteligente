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

    @Column(name = "nmusuario")
    private String nomeDoUsuario;

    @Column(name = "contato")
    private String contato;

    @Column(name = "dtCriacao")
    private LocalDateTime dataCriacaoUsuario;

    @Column(name = "dtNascimento")
    private LocalDateTime dataNascimento;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nomeDoUsuario, String contato, LocalDateTime dataCriacaoUsuario, LocalDateTime dataNascimento) {
        this.id = id;
        this.nomeDoUsuario = nomeDoUsuario;
        this.contato = contato;
        this.dataCriacaoUsuario = dataCriacaoUsuario;
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

    public LocalDateTime getDataCriacaoUsuario() {
        return dataCriacaoUsuario;
    }

    public void setDataCriacaoUsuario(LocalDateTime dataCriacaoUsuario) {
        this.dataCriacaoUsuario = dataCriacaoUsuario;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
