package com.br.EnergiaInteligente.Dto.Request;

import java.time.LocalDateTime;

public class NovaMedicaoRequestDto {

    private long consumo;

    private int tensao;

    private int corrente;

    private LocalDateTime dataHoraFimMedicao;

    private LocalDateTime dataHoraInicioMedicao;

    //private Long cdTipoMedicao;

    public long getConsumo() {
        return consumo;
    }

    public void setConsumo(long consumo) {
        this.consumo = consumo;
    }

    public int getTensao() {
        return tensao;
    }

    public void setTensao(int tensao) {
        this.tensao = tensao;
    }

    public int getCorrente() {
        return corrente;
    }

    public void setCorrente(int corrente) {
        this.corrente = corrente;
    }

    public LocalDateTime getDataHoraFimMedicao() {
        return dataHoraFimMedicao;
    }

    public void setDataHoraFimMedicao(LocalDateTime dataHoraFimMedicao) {
        this.dataHoraFimMedicao = dataHoraFimMedicao;
    }

    public LocalDateTime getDataHoraInicioMedicao() {
        return dataHoraInicioMedicao;
    }

    /*public Long getCdTipoMedicao() {
        return cdTipoMedicao;
    }

    public void setCdTipoMedicao(Long cdTipoMedicao) {
        this.cdTipoMedicao = cdTipoMedicao;
    }*/

    public void setDataHoraInicioMedicao(LocalDateTime dataHoraInicioMedicao) {
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
    }
}
