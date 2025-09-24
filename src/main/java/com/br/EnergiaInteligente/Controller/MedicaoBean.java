package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LocalizarMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.NovaMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/medicao")
public class MedicaoBean {

    @Autowired
    private MedicaoService medicaoService;

    @PostMapping("/novamedicao")
    public ResponseEntity<Void> cadastrarMedicao(
            @RequestHeader("API-Key") String apiKey,
            @Valid @RequestBody NovaMedicaoRequestDto medicaoRequestDto) {

        // Validação básica
        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("API Key não fornecida");
        }

        medicaoService.cadastrarNovaMedicao(medicaoRequestDto, apiKey);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listarmedicoes")
    public ResponseEntity<List<MedicaoPorDispositivoResponseDto>> listarMedicoesDoUsuario(@RequestHeader("Authorization") String authHeader,
                                                                                          @RequestBody LocalizarMedicaoRequestDto medicaoRequestDto){
        String token = authHeader.replace("Bearer ", "");
        List<MedicaoPorDispositivoResponseDto> medicoes = medicaoService.listarMedicoesPorUsuario(medicaoRequestDto, token);

        return ResponseEntity.ok().body(medicoes);
    }

}
