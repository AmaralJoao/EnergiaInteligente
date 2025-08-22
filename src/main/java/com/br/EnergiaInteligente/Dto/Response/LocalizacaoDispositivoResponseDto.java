package com.br.EnergiaInteligente.Dto.Response;

public class LocalizacaoDispositivoResponseDto {

    private String codigoPublicoLocalizacao;

    private String nomeDaLocalizacao;

    private String nomeDaRua;

    private int numero;

    public String getNomeDaLocalizacao() {
        return nomeDaLocalizacao;
    }

    public void setNomeDaLocalizacao(String nomeDaLocalizacao) {
        this.nomeDaLocalizacao = nomeDaLocalizacao;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPublicoLocalizacao() {
        return codigoPublicoLocalizacao;
    }

    public void setCodigoPublicoLocalizacao(String codigoPublicoLocalizacao) {
        this.codigoPublicoLocalizacao = codigoPublicoLocalizacao;
    }
}
