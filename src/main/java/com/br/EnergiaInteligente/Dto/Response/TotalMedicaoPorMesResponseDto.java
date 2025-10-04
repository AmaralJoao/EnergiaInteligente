package com.br.EnergiaInteligente.Dto.Response;

import java.math.BigDecimal;

public interface TotalMedicaoPorMesResponseDto {

    String getMes();
    BigDecimal getConsumoTotalKwh();
    BigDecimal getHorasMedidas();
    BigDecimal getCustoTotalMes();


}

