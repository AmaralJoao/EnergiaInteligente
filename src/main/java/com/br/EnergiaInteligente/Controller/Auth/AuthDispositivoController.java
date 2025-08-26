package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.VincularDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/auth/api/dispositivo")
public class AuthDispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/vincular")
    public ResponseEntity<DispositivoResponseDto>cadastrarDispositivo(VincularDispositivoRequestDto vincularDispositivoRequestDto){

        DispositivoResponseDto dispositivo = dispositivoService.vincularDispositivoUsuario(vincularDispositivoRequestDto);
        return ResponseEntity.ok().body(dispositivo);
    }

    @GetMapping("/dispositivos")
    public ResponseEntity<List<DispositivoComLocalizacaoResponseDto>> listarDispositivosDoUsuario(@RequestBody DispositivoRequesDto dispositivoRequesDto){
        List<DispositivoComLocalizacaoResponseDto> dispositivoResponseDto = dispositivoService.listarDispositivosPorUsuario(dispositivoRequesDto);


        return ResponseEntity.ok().body(dispositivoResponseDto);
    }

    @GetMapping("/identificar/{chipId}")
    public ResponseEntity<Boolean> identificarDispositivo(@PathVariable Long chipId) {
        try {
            boolean response = dispositivoService.dispositivoExiste(chipId);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dispositivo não encontrado com chipId: " + chipId
            );
        }
    }
}
