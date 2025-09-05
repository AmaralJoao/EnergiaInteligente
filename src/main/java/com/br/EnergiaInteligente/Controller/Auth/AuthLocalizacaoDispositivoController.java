package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/localizacaodispositivo")
public class AuthLocalizacaoDispositivoController {

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

    @GetMapping("/listarlocalizacoes")
    public ResponseEntity<List<LocalizacaoDispositivoResponseDto>> todasLocalizacoesDoDispositivo(@RequestBody LocalizacaoDispositivoRequestDto localizacaoDispositivoRequestDto){

        List<LocalizacaoDispositivoResponseDto> localizacaoDoDispositivo = localizacaoDispositivoService.localizacoesAntigasDoDispositivo(localizacaoDispositivoRequestDto);

        return ResponseEntity.ok().body(localizacaoDoDispositivo);
    }

}
