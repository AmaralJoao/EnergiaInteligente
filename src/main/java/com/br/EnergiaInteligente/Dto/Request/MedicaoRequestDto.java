package com.br.EnergiaInteligente.Dto.Request;

import com.br.EnergiaInteligente.Model.TipoMedicaoModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

public class MedicaoRequestDto {

    private String apiKey;

    private long consumo;

    private int tensao;

    private int corrente;

    private int tipoMedicao;

    private LocalDateTime dataHoraInicioMedicao;

    private LocalDateTime dataHoraFimMedicao;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

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

    public int getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(int tipoMedicao) {
        this.tipoMedicao = tipoMedicao;
    }

    public LocalDateTime getDataHoraInicioMedicao() {
        return dataHoraInicioMedicao;
    }

    public void setDataHoraInicioMedicao(LocalDateTime dataHoraInicioMedicao) {
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
    }

    public LocalDateTime getDataHoraFimMedicao() {
        return dataHoraFimMedicao;
    }

    public void setDataHoraFimMedicao(LocalDateTime dataHoraFimMedicao) {
        this.dataHoraFimMedicao = dataHoraFimMedicao;
    }

    // Método de validação adicional
    public boolean isValidDateRange() {
        return dataHoraInicioMedicao != null && dataHoraFimMedicao != null && !dataHoraInicioMedicao.isAfter(dataHoraFimMedicao);
    }
}
