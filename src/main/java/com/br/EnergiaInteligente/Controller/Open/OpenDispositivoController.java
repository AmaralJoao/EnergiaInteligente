package com.br.EnergiaInteligente.Controller.Open;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/open/api/dispositivo")
public class OpenDispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String>cadastrarDispositivo(@RequestBody CadastrarDispositivoRequesDto dispositivoRequesDto){

        String novoDispositivo = dispositivoService.novoDispositivo(dispositivoRequesDto);

        return ResponseEntity.ok().body(novoDispositivo);
    }

}
