package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @PostMapping("/vincular")
    public ResponseEntity<DispositivoResponseDto>vincularDispositivo(Long chipId){

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        DispositivoResponseDto dispositivo = dispositivoService.vincularDispositivoUsuario(chipId, codigoPublicoUsuario);
        return ResponseEntity.ok().body(dispositivo);
    }

    @GetMapping("/dispositivos")
    public ResponseEntity<List<DispositivoComLocalizacaoResponseDto>> listarDispositivosDoUsuario(){

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        List<DispositivoComLocalizacaoResponseDto> dispositivoResponseDto = dispositivoService.listarDispositivosPorUsuario(codigoPublicoUsuario);


        return ResponseEntity.ok().body(dispositivoResponseDto);
    }

    @GetMapping("/editar")
    public ResponseEntity<DispositivoResponseDto> editarDispositivo(DispositivoRequesDto dispositivoRequesDto){

        DispositivoResponseDto dispositivoResponseDto = dispositivoService.editarDispositivo(dispositivoRequesDto);


        return ResponseEntity.ok().body(dispositivoResponseDto);
    }

}
