package com.br.EnergiaInteligente.Dto.Request;

import com.br.EnergiaInteligente.Model.DispositivoModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class LocalizacaoDispositivoRequestDto {

    private String codigoPublicoLocalizacao;

    private String nomeDaLocalizacao;

    private String codigoPublicoDispositivo;

    private String cep;

    private String nomeDaRua;

    private int numero;

    private Double latitude;

    private Double longitude;

    public String getNomeDaLocalizacao() {
        return nomeDaLocalizacao;
    }

    public void setNomeDaLocalizacao(String nomeDaLocalizacao) {
        this.nomeDaLocalizacao = nomeDaLocalizacao;
    }

    public String getCodigoPublicoDispositivo() {
        return codigoPublicoDispositivo;
    }

    public void setCodigoPublicoDispositivo(String codigoPublicoDispositivo) {
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCodigoPublicoLocalizacao() {
        return codigoPublicoLocalizacao;
    }

    public void setCodigoPublicoLocalizacao(String codigoPublicoLocalizacao) {
        this.codigoPublicoLocalizacao = codigoPublicoLocalizacao;
    }
}
