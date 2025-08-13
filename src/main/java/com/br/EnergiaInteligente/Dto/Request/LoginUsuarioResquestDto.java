package com.br.EnergiaInteligente.Dto.Request;

public class LoginUsuarioResquestDto {

    private String emaiUsuario;

    private String senha;

    private String ip;

    private String userAgent;

    public String getEmaiUsuario() {
        return emaiUsuario;
    }

    public void setEmaiUsuario(String emaiUsuario) {
        this.emaiUsuario = emaiUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
