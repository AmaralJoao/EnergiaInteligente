package com.br.EnergiaInteligente.Dto.Response;

import jakarta.persistence.Column;

public class DispositivoResponseDto {

    private String nomeDoDispositivo;

    private String modeloDispositivo;

    private long versaoDoDispositivo;

    private LocalizacaoDispositivoResponseDto localizacaoDispositivo;

    private LocalizacaoResponseDto localizacao;

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

    public LocalizacaoDispositivoResponseDto getLocalizacaoDispositivo() {
        return localizacaoDispositivo;
    }

    public void setLocalizacaoDispositivo(LocalizacaoDispositivoResponseDto localizacaoDispositivo) {
        this.localizacaoDispositivo = localizacaoDispositivo;
    }

    public LocalizacaoResponseDto getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoResponseDto localizacao) {
        this.localizacao = localizacao;
    }
}
