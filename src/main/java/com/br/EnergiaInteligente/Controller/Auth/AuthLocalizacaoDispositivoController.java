package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listarlocalizacaoativa/{codigoPublicoDoDispositivo}")
    public ResponseEntity<LocalizacaoDispositivoResponseDto> localizacaoAtivaDoDispositivo(@RequestParam String codigoPublicoDoDispositivo){

        LocalizacaoDispositivoResponseDto localizacaoDoDispositivo = localizacaoDispositivoService.encontrarLocalizacaoAtivaDoDispositivo(codigoPublicoDoDispositivo);

        return ResponseEntity.ok().body(localizacaoDoDispositivo);
    }

}
