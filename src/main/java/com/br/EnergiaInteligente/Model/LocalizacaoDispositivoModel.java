package com.br.EnergiaInteligente.Model;

import com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "localizacaoDispositivo")
public class LocalizacaoDispositivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdLocalizacaoDispositivo")
    private long id;

    @Column(name = "cdPublico", unique = true, nullable = false, updatable = false, length = 20)
    private String codigoPublico;

    @ManyToOne
    @JoinColumn(name = "cdLocalizacao")
    private LocalizacaoModel localizacao;

    @ManyToOne
    @JoinColumn(name = "cdDispositivo")
    private DispositivoModel dispositivo;

    @Column(name = "nmDaLocalizacaoDoDispositivo")
    private String nomeDaLocalizacaoDoDispositivo;

    @Column(name = "dtFim")
    private LocalDateTime dataInicio;

    @Column(name = "dtInicio")
    private LocalDateTime dataFim;

    public LocalizacaoDispositivoModel() {
    }

    public LocalizacaoDispositivoModel(long id, LocalizacaoModel localizacao, DispositivoModel dispositivo, String nomeDaLocalizacaoDoDispositivo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.localizacao = localizacao;
        this.dispositivo = dispositivo;
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @PrePersist
    public void prePersist() {
        if (this.codigoPublico == null) {
            this.codigoPublico = GeradoIdentificadorUtil.generateSecureId().toUpperCase();
        }
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

    public LocalizacaoModel getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoModel localizacao) {
        this.localizacao = localizacao;
    }

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getNomeDaLocalizacaoDoDispositivo() {
        return nomeDaLocalizacaoDoDispositivo;
    }

    public void setNomeDaLocalizacaoDoDispositivo(String nomeDaLocalizacaoDoDispositivo) {
        this.nomeDaLocalizacaoDoDispositivo = nomeDaLocalizacaoDoDispositivo;
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
