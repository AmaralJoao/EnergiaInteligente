package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/localizacao")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;
    @Autowired
    AutenticacaoUtils autenticacaoUtils;

    @PostMapping("/novalocalizacao")
    public ResponseEntity<LocalizacaoResponseDto> cadastrarNovaLocalizacao(LocalizacaoRequestDto localizacaoRequestDto){

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        LocalizacaoResponseDto novaLocalizacao = localizacaoService.criarLocalizacao(localizacaoRequestDto, codigoPublicoUsuario);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @PostMapping("/editar")
    public ResponseEntity<LocalizacaoResponseDto> editarLocalizacao(LocalizacaoRequestDto localizacaoRequestDto){

        LocalizacaoResponseDto novaLocalizacao = localizacaoService.editarLocalizacao(localizacaoRequestDto);

        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @GetMapping("/localizacoes")
    public ResponseEntity<List<LocalizacaoResponseDto>> listarLocalizacoesPorUsuario(){

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        List<LocalizacaoResponseDto> novaLocalizacao = localizacaoService.LocalizacoesPorUsuario(codigoPublicoUsuario);

        return ResponseEntity.ok().body(novaLocalizacao);
    }
}
