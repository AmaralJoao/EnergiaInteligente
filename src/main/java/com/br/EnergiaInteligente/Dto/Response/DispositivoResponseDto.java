package com.br.EnergiaInteligente.Dto.Response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class DispositivoResponseDto {

    private Long id;
    private String nomeDoDispositivo;
    private String modeloDispositivo;
    private long versaoDoDispositivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoDispositivo() {
        return nomeDoDispositivo;
    }

    public void setNomeDoDispositivo(String nomeDoDispositivo) {
        this.nomeDoDispositivo = nomeDoDispositivo;
    }

    public String getModeloDispositivo() {
        return modeloDispositivo;
    }

    public void setModeloDispositivo(String modeloDispositivo) {
        this.modeloDispositivo = modeloDispositivo;
    }

    public long getVersaoDoDispositivo() {
        return versaoDoDispositivo;
    }

    public void setVersaoDoDispositivo(long versaoDoDispositivo) {
        this.versaoDoDispositivo = versaoDoDispositivo;
    }
}
