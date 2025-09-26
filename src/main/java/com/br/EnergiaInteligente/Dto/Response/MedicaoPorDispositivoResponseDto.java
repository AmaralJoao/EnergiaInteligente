package com.br.EnergiaInteligente.Dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MedicaoPorDispositivoResponseDto {
    private String nomeDispositivo;
    private Long consumo;
    private Integer tensao;
    private Integer corrente;
    private String tipoMedicao;
    private LocalDateTime dataHoraFimMedicao;
    private LocalDateTime dataHoraInicioMedicao;
    private String codigoPublicoDispositivo;

    public MedicaoPorDispositivoResponseDto() {
    }

    public MedicaoPorDispositivoResponseDto(String nomeDispositivo, Long consumo, Integer tensao, Integer corrente, String tipoMedicao, LocalDateTime dataHoraFimMedicao, LocalDateTime dataHoraInicioMedicao, String codigoPublicoDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
        this.consumo = consumo;
        this.tensao = tensao;
        this.corrente = corrente;
        this.tipoMedicao = tipoMedicao;
        this.dataHoraFimMedicao = dataHoraFimMedicao;
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
    }

}
