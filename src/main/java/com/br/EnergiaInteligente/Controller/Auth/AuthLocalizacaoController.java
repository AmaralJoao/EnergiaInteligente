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
    public ResponseEntity<LocalizacaoResponseDto> cadastrarNovaLocalizacao(@RequestBody LocalizacaoRequestDto localizacaoRequestDto){
        LocalizacaoResponseDto novaLocalizacao = localizacaoService.criarLocalizacao(localizacaoRequestDto);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @PostMapping("/editarlocalizacao")
    public ResponseEntity<LocalizacaoResponseDto> editarLocalizacao(@RequestBody LocalizacaoRequestDto localizacaoRequestDto){
        LocalizacaoResponseDto novaLocalizacao = localizacaoService.editarLocalizacao(localizacaoRequestDto);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @GetMapping("/listarlocalizacao")
    public ResponseEntity<List<LocalizacaoResponseDto>> listarLocalizacoesPorUsuario(@RequestBody LocalizacaoRequestDto localizacaoRequestDto){
        List<LocalizacaoResponseDto> novaLocalizacao = localizacaoService.LocalizacoesPorUsuario(localizacaoRequestDto);

        return ResponseEntity.ok().body(novaLocalizacao);
    }
}
