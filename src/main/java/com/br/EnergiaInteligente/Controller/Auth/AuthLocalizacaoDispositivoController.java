package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api/localizacaodispositivo")
public class AuthLocalizacaoDispositivoController {

    @Autowired
    private LocalizacaoDispositivoService localizacaoDispositivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LocalizacaoDispositivoResponseDto> cadastroLocalizacao(LocalizacaoDispositivoRequestDto request){
        LocalizacaoDispositivoResponseDto dispositivoLocalizado = localizacaoDispositivoService.cadastrarLocalizacao(request);

        return ResponseEntity.ok().body(dispositivoLocalizado);
    }
}
