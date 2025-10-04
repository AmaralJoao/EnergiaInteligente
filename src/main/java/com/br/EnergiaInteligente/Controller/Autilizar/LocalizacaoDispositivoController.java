package com.br.EnergiaInteligente.Controller.Autilizar;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacaodispositivo")
public class LocalizacaoDispositivoController {

    @Autowired
    private LocalizacaoDispositivoService localizacaoDispositivoService;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

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
    public ResponseEntity<List<LocalizacaoDispositivoResponseDto>> todasLocalizacoesDoDispositivo(/*, @RequestBody LocalizacaoDispositivoRequestDto localizacaoDispositivoRequestDto*/){

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        List<LocalizacaoDispositivoResponseDto> localizacaoDoDispositivo = localizacaoDispositivoService.localizacoesAntigasDoDispositivo(codigoPublicoUsuario/*localizacaoDispositivoRequestDto*/);


        return ResponseEntity.ok().body(localizacaoDoDispositivo);
    }

}
