package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "localizacaoDispositivo")
public class LocalizacaoDispositivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdLocalizacaoDispositivo")
    private long id;

    @Column(name = "nmLocalizacao")
    private String nomeDaLocalizacao;

    @OneToOne
    @JoinColumn(name = "cdDispositivo")
    private DispositivoModel dispositivo;

    @Column(name = "cep")
    private String cep;

    @Column(name = "nmRua")
    private String nomeDaRua;

    @Column(name = "numero")
    private int numero;

    @Column(name = "nrLatitude")
    private Double latitude;

    @Column(name = "nrLongitude")
    private Double longitude;

    public LocalizacaoDispositivoModel() {
    }

    public LocalizacaoDispositivoModel(long id, String nomeDaLocalizacao, DispositivoModel dispositivo, String cep, String nomeDaRua, int numero, Double latitude, Double longitude) {
        this.id = id;
        this.nomeDaLocalizacao = nomeDaLocalizacao;
        this.dispositivo = dispositivo;
        this.cep = cep;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaLocalizacao() {
        return nomeDaLocalizacao;
    }

    public void setNomeDaLocalizacao(String nomeDaLocalizacao) {
        this.nomeDaLocalizacao = nomeDaLocalizacao;
    }

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
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
}
