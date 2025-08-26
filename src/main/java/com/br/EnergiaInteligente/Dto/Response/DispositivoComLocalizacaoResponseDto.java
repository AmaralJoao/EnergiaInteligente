package com.br.EnergiaInteligente.Dto.Response;

public class DispositivoComLocalizacaoResponseDto {

    private String nomeDoDispositivo;

    private String modeloDispositivo;

    private long versaoDoDispositivo;

    private String nomeDaLocalizacaoDoDispositivo;

    private String cidade;

    private String nomeDaRua;

    private int numero;

    private String complemento;

    // Construtor para a JPQL
    public DispositivoComLocalizacaoResponseDto(String nomeDoDispositivo,
                                                String modeloDispositivo,
                                                long versaoDoDispositivo,
                                                String nomeDaLocalizacaoDoDispositivo,
                                                String cidade,
                                                String nomeDaRua,
                                                int numero,
                                                String complemento) {
        this.nomeDoDispositivo = nomeDoDispositivo;
        this.modeloDispositivo = modeloDispositivo;
        this.versaoDoDispositivo = versaoDoDispositivo;
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
        this.cidade = cidade;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Construtor vazio (obrigatório)
    public DispositivoComLocalizacaoResponseDto() {}

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
}
