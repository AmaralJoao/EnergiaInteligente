package com.br.EnergiaInteligente.Controller.Auth;

import com.br.EnergiaInteligente.Dto.Request.LocalizarMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.NovaMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/medicao")
public class AuthMedicaoController {

    @Autowired
    private MedicaoService medicaoService;

    @PostMapping("/novamedicao")
    public ResponseEntity<Void> cadastrarMedicao(@RequestBody NovaMedicaoRequestDto medicaoRequestDto){

        medicaoService.CadastrarNovaMedicao(medicaoRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listarmedicoes")
    public ResponseEntity<List<MedicaoPorDispositivoResponseDto>> listarMedicoesDoUsuario(@RequestBody LocalizarMedicaoRequestDto medicaoRequestDto){
        List<MedicaoPorDispositivoResponseDto> medicoes = medicaoService.listarMedicoesPorUsuario(medicaoRequestDto);

        return ResponseEntity.ok().body(medicoes);
    }
}
