package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/localizacao")
public class AuthLocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping("/novalocalizacao")
    public ResponseEntity<LocalizacaoResponseDto> cadastrarNovaLocalizacao(@RequestHeader("Authorization") String authHeader,
                                                                           @RequestBody LocalizacaoRequestDto localizacaoRequestDto){

        String token = authHeader.replace("Bearer ", "");

        LocalizacaoResponseDto novaLocalizacao = localizacaoService.criarLocalizacao(localizacaoRequestDto, token);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @PostMapping("/editarlocalizacao")
    public ResponseEntity<LocalizacaoResponseDto> editarLocalizacao(@RequestHeader("Authorization") String authHeader, @RequestBody LocalizacaoRequestDto localizacaoRequestDto){
        LocalizacaoResponseDto novaLocalizacao = localizacaoService.editarLocalizacao(localizacaoRequestDto);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @GetMapping("/listarlocalizacao")
    public ResponseEntity<List<LocalizacaoResponseDto>> listarLocalizacoesPorUsuario(@RequestHeader("Authorization") String authHeader){

        String token = authHeader.replace("Bearer ", "");

        List<LocalizacaoResponseDto> novaLocalizacao = localizacaoService.LocalizacoesPorUsuario(token);

        return ResponseEntity.ok().body(novaLocalizacao);
    }
}
