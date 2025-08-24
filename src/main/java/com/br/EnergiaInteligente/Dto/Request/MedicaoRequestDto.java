package com.br.EnergiaInteligente.Dto.Request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class MedicaoRequestDto {

    @NotNull(message = "Data de início é obrigatória")
    @FutureOrPresent(message = "Data de início não pode ser no passado")
    private LocalDateTime dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    @FutureOrPresent(message = "Data de fim não pode ser no passado")
    private LocalDateTime dataFim;

    @NotNull(message = "Data de fim é obrigatória")
    private String codigoUsuario;

    // Opcional: caso queira filtrar por dispositivos específicos
    private List<String> dispositivosIds;

    // Construtores
    public MedicaoRequestDto() {}

    public MedicaoRequestDto(LocalDateTime dataInicio, LocalDateTime dataFim) {
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

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
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
