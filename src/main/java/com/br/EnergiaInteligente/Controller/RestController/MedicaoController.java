package com.br.EnergiaInteligente.Controller.RestController;

import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicao")
public class MedicaoController {

    @Autowired
    private MedicaoService medicaoService;

    @PostMapping("/novamedicao")
    public ResponseEntity<Void> cadastrarMedicao(@RequestBody MedicaoRequestDto medicaoRequestDto){

        medicaoService.CadastrarNovaMedicao(medicaoRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
