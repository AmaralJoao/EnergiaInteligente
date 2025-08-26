package com.br.EnergiaInteligente.Dto.Request;

import com.br.EnergiaInteligente.Model.DispositivoModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class LocalizacaoDispositivoRequestDto {

    private String codigoPublicoLocalizacaoDoDispositivo;

    private String codigoPublicoLocalizacao;

    private String codigoPublicoDispositivo;

    private String nomeDaLocalizacaoDoDispositivo;

    public String getCodigoPublicoLocalizacaoDoDispositivo() {
        return codigoPublicoLocalizacaoDoDispositivo;
    }

    public void setCodigoPublicoLocalizacaoDoDispositivo(String codigoPublicoLocalizacaoDoDispositivo) {
        this.codigoPublicoLocalizacaoDoDispositivo = codigoPublicoLocalizacaoDoDispositivo;
    }

    public String getCodigoPublicoLocalizacao() {
        return codigoPublicoLocalizacao;
    }

    public void setCodigoPublicoLocalizacao(String codigoPublicoLocalizacao) {
        this.codigoPublicoLocalizacao = codigoPublicoLocalizacao;
    }

    public String getCodigoPublicoDispositivo() {
        return codigoPublicoDispositivo;
    }

    public void setCodigoPublicoDispositivo(String codigoPublicoDispositivo) {
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
    }

    public String getNomeDaLocalizacaoDoDispositivo() {
        return nomeDaLocalizacaoDoDispositivo;
    }

    public void setNomeDaLocalizacaoDoDispositivo(String nomeDaLocalizacaoDoDispositivo) {
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
    }
}
