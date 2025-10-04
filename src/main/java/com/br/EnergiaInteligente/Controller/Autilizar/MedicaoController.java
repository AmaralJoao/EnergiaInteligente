package com.br.EnergiaInteligente.Controller.Autilizar;

import com.br.EnergiaInteligente.Dto.Request.LocalizarMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicao")
public class MedicaoController {

    @Autowired
    private MedicaoService medicaoService;

    @GetMapping("/medicoesdispositivos")
    public ResponseEntity<List<MedicaoResponseDto>> listarMedicoesDoDispositivo(@RequestHeader String apiKey){

        List<MedicaoResponseDto> medicoes = medicaoService.listarMedicoesDoDispositivo(apiKey);

        return ResponseEntity.ok().body(medicoes);
    }

    @GetMapping("/listarmedicoes")
    public ResponseEntity<List<MedicaoPorDispositivoResponseDto>> listarMedicoesDoUsuario(@RequestHeader("Authorization") String authHeader,
                                                                                          @RequestBody LocalizarMedicaoRequestDto medicaoRequestDto){
        String token = authHeader.replace("Bearer ", "");
        List<MedicaoPorDispositivoResponseDto> medicoes = medicaoService.listarMedicoesPorUsuario(medicaoRequestDto, token);

        return ResponseEntity.ok().body(medicoes);
    }
}
