package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/dispositivo")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String>cadastrarDispositivo(@RequestBody CadastrarDispositivoRequesDto dispositivoRequesDto){

        String novoDispositivo = dispositivoService.novoDispositivo(dispositivoRequesDto);

        return ResponseEntity.ok().body(novoDispositivo);
    }

}
