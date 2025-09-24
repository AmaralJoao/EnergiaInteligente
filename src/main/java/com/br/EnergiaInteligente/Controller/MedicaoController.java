package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/medicao")
public class MedicaoController {

    @Autowired
    private MedicaoService medicaoService;

    @GetMapping("/medicoesdispositivos")
    public ResponseEntity<List<MedicaoResponseDto>> listarMedicoesDoDispositivo(@RequestHeader String apiKey){

        List<MedicaoResponseDto> medicoes = medicaoService.listarMedicoesDoDispositivo(apiKey);

        return ResponseEntity.ok().body(medicoes);
    }
}
