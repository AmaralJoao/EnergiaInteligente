package com.br.EnergiaInteligente.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class LocalizarMedicaoRequestDto {
    @NotNull(message = "Data de início é obrigatória")
    @FutureOrPresent(message = "Data de início não pode ser no passado")
    //@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    @FutureOrPresent(message = "Data de fim não pode ser no passado")
    //@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataFim;

    // Opcional: caso queira filtrar por dispositivos específicos
    private List<String> dispositivosIds;

    // Construtores
    public LocalizarMedicaoRequestDto() {}

    public LocalizarMedicaoRequestDto(LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public List<String> getDispositivosIds() {
        return dispositivosIds;
    }

    public void setDispositivosIds(List<String> dispositivosIds) {
        this.dispositivosIds = dispositivosIds;
    }

    // Método de validação adicional
    public boolean isValidDateRange() {
        return dataInicio != null && dataFim != null && !dataInicio.isAfter(dataFim);
    }
}
