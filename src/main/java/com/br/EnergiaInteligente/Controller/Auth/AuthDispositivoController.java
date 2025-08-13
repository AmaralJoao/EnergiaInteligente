package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api/dispositivo")
public class AuthDispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<DispositivoResponseDto>cadastrarDispositivo(CadastrarDispositivoRequesDto dispositivoRequesDto){

        DispositivoResponseDto novoDispositivo = dispositivoService.novoDispositivo(dispositivoRequesDto);

        return ResponseEntity.ok().body(novoDispositivo);
    }
}
