package com.br.EnergiaInteligente.Dto.Response;

import java.time.LocalDateTime;

public class MedicaoResumoResponseDto {

    private LocalDateTime dataMedicao;
    private Double consumoKwh;

    public MedicaoResumoResponseDto(LocalDateTime dataMedicao, Double consumoKwh) {
        this.dataMedicao = dataMedicao;
        this.consumoKwh = consumoKwh;
    }

    // getters e setters
    public LocalDateTime getDataMedicao() { return dataMedicao; }
    public void setDataMedicao(LocalDateTime dataMedicao) { this.dataMedicao = dataMedicao; }

    public Double getConsumoKwh() { return consumoKwh; }
    public void setConsumoKwh(Double consumoKwh) { this.consumoKwh = consumoKwh; }
}
