package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sesao")
public class SessaoModel {

    @Id
    private String token; // UUID como chave primária

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdEstabelecimento")
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdDispositivo")
    private DispositivoModel dispositivo;

    private LocalDateTime criadaEm;

    private LocalDateTime expiraEm;

    private boolean ativa;

    private String ip;

    private String userAgent;

    public SessaoModel() {
    }

    public SessaoModel(String token, UsuarioModel usuario, DispositivoModel dispositivo, LocalDateTime criadaEm, LocalDateTime expiraEm, boolean ativa, String ip, String userAgent) {
        this.token = token;
        this.usuario = usuario;
        this.dispositivo = dispositivo;
        this.criadaEm = criadaEm;
        this.expiraEm = expiraEm;
        this.ativa = ativa;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    public LocalDateTime getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDateTime expiraEm) {
        this.expiraEm = expiraEm;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
