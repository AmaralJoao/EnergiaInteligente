package com.br.EnergiaInteligente.Model;

import com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "localizacao")
public class LocalizacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_localizacao")
    private long id;

    @Column(name = "codigo_publico", unique = true, nullable = false, updatable = false, length = 15)
    private String codigoPublico;

    @Column(name = "id_ativo")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "cd_usuario")
    private UsuarioModel usuario;

    @Column(name = "ds_localizacao")
    private String descricao;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "nm_rua", length = 200)
    private String nomeDaRua;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento_localizacao", length = 200)
    private String complemento;

    @Column(name = "nr_latitude")
    private Double latitude;

    @Column(name = "nr_longitude")
    private Double longitude;

    @Column(name = "dt_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "dt_fim")
    private LocalDateTime dataFim;

    public LocalizacaoModel() {
    }

    public LocalizacaoModel(long id, String codigoPublico, boolean status, UsuarioModel usuario, String descricao, String cep, String estado, String cidade, String nomeDaRua, int numero, String complemento, Double latitude, Double longitude, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.codigoPublico = codigoPublico;
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

    @PrePersist
    public void prePersist() {
        if (this.codigoPublico == null) {
            this.codigoPublico = GeradoIdentificadorUtil.generateSecureId().toUpperCase();
        }
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return "LocalizacaoModel{" +
                "id=" + id +
                ", codigoPublico='" + codigoPublico + '\'' +
                ", status=" + status +
                ", usuario=" + usuario +
                ", descricao='" + descricao + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", nomeDaRua='" + nomeDaRua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}