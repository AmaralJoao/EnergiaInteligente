package com.br.EnergiaInteligente.Dto.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUsuarioResponseDto {

    private String token;

    public LoginUsuarioResponseDto(String token) {
        this.token = token;
    }

}
