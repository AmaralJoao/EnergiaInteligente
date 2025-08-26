package com.br.EnergiaInteligente.Model;

import com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "localizacao")
public class LocalizacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdLocalizacao")
    private long id;

    @Column(name = "codigoPublico")
    private String codigoPublico;

    @Column(name = "idAtivo")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "cdUsuario")
    private UsuarioModel usuario;

    @Column(name = "dsLocalizacao")
    private String descricao;

    @Column(name = "cep")
    private String cep;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "nmRua")
    private String nomeDaRua;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complementoLocalizacao")
    private String complemento;

    @Column(name = "nrLatitude")
    private Double latitude;

    @Column(name = "nrLongitude")
    private Double longitude;

    @Column(name = "dtFim")
    private LocalDateTime dataInicio;

    @Column(name = "dtInicio")
    private LocalDateTime dataFim;

    public LocalizacaoModel() {
    }

    public LocalizacaoModel(long id, boolean status, UsuarioModel usuario, String descricao, String cep, String estado, String cidade, String nomeDaRua, int numero, String complemento, Double latitude, Double longitude, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.codigoPublico = GeradoIdentificadorUtil.generateSecureId().toUpperCase();
        this.status = status;
        this.usuario = usuario;
        this.descricao = descricao;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoPublico() {
        return codigoPublico;
    }

    public void setCodigoPublico(String codigoPublico) {
        this.codigoPublico = codigoPublico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
