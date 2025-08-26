package com.br.EnergiaInteligente.Dto.Response;

public class LocalizacaoDispositivoResponseDto {

    private String codigoPublicoLocalizacaoDoDispositivo;

    private String nomeDaLocalizacaoDoDispositivo;

    private int numero;

    public String getNomeDaLocalizacaoDoDispositivo() {
        return nomeDaLocalizacaoDoDispositivo;
    }

    public void setNomeDaLocalizacaoDoDispositivo(String nomeDaLocalizacao) {
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPublicoLocalizacaoDoDispositivo() {
        return codigoPublicoLocalizacaoDoDispositivo;
    }

    public void setCodigoPublicoLocalizacaoDoDispositivo(String codigoPublicoLocalizacao) {
        this.codigoPublicoLocalizacaoDoDispositivo = codigoPublicoLocalizacao;
    }
}
