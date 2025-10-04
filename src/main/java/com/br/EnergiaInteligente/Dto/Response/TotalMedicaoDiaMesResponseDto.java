package com.br.EnergiaInteligente.Dto.Response;

import java.time.LocalDate;

public interface TotalMedicaoDiaMesResponseDto {

    Long getConsumoTotalKwh();
    Long getTotalValor();
    Double getTotalHoras();
}
