package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/localizacaodispositivo")
public class LocalizacaoDispositivoBean {

    @Autowired
    private LocalizacaoDispositivoService localizacaoDispositivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LocalizacaoDispositivoResponseDto> cadastroLocalizacaoDoDispositivo(@RequestBody LocalizacaoDispositivoRequestDto request){
        LocalizacaoDispositivoResponseDto dispositivoLocalizado = localizacaoDispositivoService.cadastrarLocalizacaoDoDispositivo(request);

        return ResponseEntity.ok().body(dispositivoLocalizado);
    }

    @PostMapping("/editar")
    public ResponseEntity<LocalizacaoDispositivoResponseDto> editarLocalizacaoDoDispositivo(@RequestBody LocalizacaoDispositivoRequestDto request){
        LocalizacaoDispositivoResponseDto localizacaoEditada = localizacaoDispositivoService.editarLocalizacaoDoDispositivo(request);

        return ResponseEntity.ok().body(localizacaoEditada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LocalizacaoDispositivoResponseDto>> todasLocalizacoesDoDispositivo(@RequestHeader("Authorization") String authHeader/*, @RequestBody LocalizacaoDispositivoRequestDto localizacaoDispositivoRequestDto*/){

        String token = authHeader.replace("Bearer ","");

        List<LocalizacaoDispositivoResponseDto> localizacaoDoDispositivo = localizacaoDispositivoService.localizacoesAntigasDoDispositivo(token/*localizacaoDispositivoRequestDto*/);


        return ResponseEntity.ok().body(localizacaoDoDispositivo);
    }

}
