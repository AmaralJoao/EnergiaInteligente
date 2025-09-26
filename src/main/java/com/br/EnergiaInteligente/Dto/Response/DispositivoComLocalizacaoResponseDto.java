package com.br.EnergiaInteligente.Dto.Response;

import lombok.Getter;
import lombok.Setter;


public class DispositivoComLocalizacaoResponseDto {

    private Long id;
    private String codigoPublicoDispositivo;
    private String nomeDoDispositivo;
    private String modeloDispositivo;
    private Long versaoDoDispositivo; // trocado de long -> Long
    private String nomeDaLocalizacaoDoDispositivo;
    private String cidade;
    private String nomeDaRua;
    private Integer numero;
    private String complemento;


    public DispositivoComLocalizacaoResponseDto(Long id, String codigoPublicoDispositivo, String nomeDoDispositivo, String modeloDispositivo, Long versaoDoDispositivo, String nomeDaLocalizacaoDoDispositivo, String cidade, String nomeDaRua, Integer numero, String complemento) {
        this.id = id;
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
        this.nomeDoDispositivo = nomeDoDispositivo;
        this.modeloDispositivo = modeloDispositivo;
        this.versaoDoDispositivo = versaoDoDispositivo;
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
        this.cidade = cidade;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public DispositivoComLocalizacaoResponseDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPublicoDispositivo() {
        return codigoPublicoDispositivo;
    }

    public void setCodigoPublicoDispositivo(String codigoPublicoDispositivo) {
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
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

    public Long getVersaoDoDispositivo() {
        return versaoDoDispositivo;
    }

    public void setVersaoDoDispositivo(Long versaoDoDispositivo) {
        this.versaoDoDispositivo = versaoDoDispositivo;
    }

    public String getNomeDaLocalizacaoDoDispositivo() {
        return nomeDaLocalizacaoDoDispositivo;
    }

    public void setNomeDaLocalizacaoDoDispositivo(String nomeDaLocalizacaoDoDispositivo) {
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
