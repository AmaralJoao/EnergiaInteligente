package com.br.EnergiaInteligente.Dto.Response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class LocalizacaoDispositivoResponseDto {

    private Long id;
    private Long idDispositivo;
    private String nomeDaLocalizacaoDoDispositivo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNomeDaLocalizacaoDoDispositivo() {
        return nomeDaLocalizacaoDoDispositivo;
    }

    public void setNomeDaLocalizacaoDoDispositivo(String nomeDaLocalizacaoDoDispositivo) {
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
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
}
