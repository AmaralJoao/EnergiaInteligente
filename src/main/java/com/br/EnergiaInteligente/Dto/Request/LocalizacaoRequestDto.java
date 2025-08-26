package com.br.EnergiaInteligente.Dto.Request;

public class LocalizacaoRequestDto {

    private String codigoPublicoLocalizacao;
    private String codigoPublicoUsuario;
    private String descricao;
    private String cep;
    private String cidade;
    private String nomeDaRua;
    private int numero;
    private String complemento;

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

    public String getCodigoPublicoUsuario() {
        return codigoPublicoUsuario;
    }

    public void setCodigoPublicoUsuario(String codigoPublicoUsuario) {
        this.codigoPublicoUsuario = codigoPublicoUsuario;
    }
}
