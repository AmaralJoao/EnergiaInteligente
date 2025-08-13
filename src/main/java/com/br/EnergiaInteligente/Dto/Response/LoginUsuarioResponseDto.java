package com.br.EnergiaInteligente.Dto.Response;

public class LoginUsuarioResponseDto {

    private String token;

    public LoginUsuarioResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
