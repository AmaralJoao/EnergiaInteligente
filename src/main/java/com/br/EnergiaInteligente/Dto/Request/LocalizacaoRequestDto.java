package com.br.EnergiaInteligente.Dto.Request;

public class LocalizacaoRequestDto {

    private Long id;
    private String codigoPublicoLocalizacao;
    private String descricao;
    private String cep;
    private String cidade;
    private String nomeDaRua;
    private int numero;
    private String complemento;
    private boolean status;

    public String getCodigoPublicoLocalizacao() {
        return codigoPublicoLocalizacao;
    }

    public void setCodigoPublicoLocalizacao(String codigoPublicoLocalizacao) {
        this.codigoPublicoLocalizacao = codigoPublicoLocalizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
