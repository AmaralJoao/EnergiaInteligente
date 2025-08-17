package com.br.EnergiaInteligente.Controller.Open;

import com.br.EnergiaInteligente.Dto.Request.LoginUsuarioResquestDto;
import com.br.EnergiaInteligente.Dto.Response.LoginUsuarioResponseDto;
import com.br.EnergiaInteligente.Service.AutenticacaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open/api/autenticar")
public class OpenAutenticacaoController {
    @Autowired
    private AutenticacaoService authService;

    @PostMapping("/usuario/login")
    public ResponseEntity<LoginUsuarioResponseDto> logar(@RequestBody LoginUsuarioResquestDto loginRequestDto, HttpServletRequest request){
        String token = authService.autenticar(loginRequestDto.getEmaiUsuario(), loginRequestDto.getSenha(),
                request.getRemoteAddr(),
                request.getHeader("User-Agent"));
        return ResponseEntity.ok(new LoginUsuarioResponseDto(token));
    }

    @PostMapping("/logoutusuario")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Session ")) {
            String token = authHeader.substring(8);
            authService.logout(token);
        }
        return ResponseEntity.noContent().build();
    }
}
