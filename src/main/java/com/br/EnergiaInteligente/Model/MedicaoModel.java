package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicao")
public class MedicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdMedicacao")
    private long id;

    @Column(name = "cdPublico", unique = true, nullable = false, updatable = false, length = 20)
    private String codigoPublico;

    @ManyToOne
    @JoinColumn(name = "cdDispositivo")
    private DispositivoModel dispositivo;

    @Column(name = "consumo_kwh", nullable = false)
    private Double consumoKwh;

    private Double consumoWh;

    @Column(name = "potencia_media_w")
    private Double potenciaMediaW;

    @Column(name = "potencia_maxima_w")
    private Double potenciaMaximaW;

    @Column(name = "potencia_minima_w")
    private Double potenciaMinimaW;

    @Column(name = "corrente_media_a")
    private Double correnteMediaA;

    @Column(name = "corrente_maxima_a")
    private Double correnteMaximaA;

    @Column(name = "corrente_minima_a")
    private Double correnteMinimaA;

    @Column(name = "contagem_medicoes")
    private Integer contagemMedicoes;

    @Column(name = "completude_dados")
    private Double completudeDados;

    @ManyToOne
    @JoinColumn(name = "cdTipoMedicao")
    private TipoMedicaoModel tipoMedicao;

    @Column(name = "dataHoraInicioMedicao")
    private LocalDateTime dataHoraInicioMedicao;

    @Column(name = "dataHoraFimMedicao")
    private LocalDateTime dataHoraFimMedicao;

    @Column(name = "custo_total")
    private Double custoTotal;

    private Double valorTarifa;

    private Double duracaoHoras;


    //private Float fatorCorrente;  // Fator de calibração do sensor SCT-013


    public MedicaoModel(long id, String codigoPublico, DispositivoModel dispositivo, Double consumoKwh, Double consumoWh, Double potenciaMediaW, Double potenciaMaximaW, Double potenciaMinimaW, Double correnteMediaA, Double correnteMaximaA, Double correnteMinimaA, Integer contagemMedicoes, Double completudeDados, TipoMedicaoModel tipoMedicao, LocalDateTime dataHoraInicioMedicao, LocalDateTime dataHoraFimMedicao, Double custoTotal, Double valorTarifa, Double duracaoHoras) {
        this.id = id;
        this.codigoPublico = codigoPublico;
        this.dispositivo = dispositivo;
        this.consumoKwh = consumoKwh;
        this.consumoWh = consumoWh;
        this.potenciaMediaW = potenciaMediaW;
        this.potenciaMaximaW = potenciaMaximaW;
        this.potenciaMinimaW = potenciaMinimaW;
        this.correnteMediaA = correnteMediaA;
        this.correnteMaximaA = correnteMaximaA;
        this.correnteMinimaA = correnteMinimaA;
        this.contagemMedicoes = contagemMedicoes;
        this.completudeDados = completudeDados;
        this.tipoMedicao = tipoMedicao;
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
        this.dataHoraFimMedicao = dataHoraFimMedicao;
        this.custoTotal = custoTotal;
        this.valorTarifa = valorTarifa;
        this.duracaoHoras = duracaoHoras;
    }

    public MedicaoModel() {
    }



    @PrePersist
    public void prePersist() {
        if (this.codigoPublico == null) {
            this.codigoPublico = com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil.generateSecureId().toUpperCase();
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

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Double getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(Double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public Double getPotenciaMediaW() {
        return potenciaMediaW;
    }

    public void setPotenciaMediaW(Double potenciaMediaW) {
        this.potenciaMediaW = potenciaMediaW;
    }

    public Double getPotenciaMaximaW() {
        return potenciaMaximaW;
    }

    public void setPotenciaMaximaW(Double potenciaMaximaW) {
        this.potenciaMaximaW = potenciaMaximaW;
    }

    public Double getPotenciaMinimaW() {
        return potenciaMinimaW;
    }

    public void setPotenciaMinimaW(Double potenciaMinimaW) {
        this.potenciaMinimaW = potenciaMinimaW;
    }

    public Double getCorrenteMediaA() {
        return correnteMediaA;
    }

    public void setCorrenteMediaA(Double correnteMediaA) {
        this.correnteMediaA = correnteMediaA;
    }

    public Double getCorrenteMaximaA() {
        return correnteMaximaA;
    }

    public void setCorrenteMaximaA(Double correnteMaximaA) {
        this.correnteMaximaA = correnteMaximaA;
    }

    public Double getCorrenteMinimaA() {
        return correnteMinimaA;
    }

    public void setCorrenteMinimaA(Double correnteMinimaA) {
        this.correnteMinimaA = correnteMinimaA;
    }

    public Integer getContagemMedicoes() {
        return contagemMedicoes;
    }

    public void setContagemMedicoes(Integer contagemMedicoes) {
        this.contagemMedicoes = contagemMedicoes;
    }

    public Double getCompletudeDados() {
        return completudeDados;
    }

    public void setCompletudeDados(Double completudeDados) {
        this.completudeDados = completudeDados;
    }

    public TipoMedicaoModel getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(TipoMedicaoModel tipoMedicao) {
        this.tipoMedicao = tipoMedicao;
    }

    public LocalDateTime getDataHoraInicioMedicao() {
        return dataHoraInicioMedicao;
    }

    public void setDataHoraInicioMedicao(LocalDateTime dataHoraInicioMedicao) {
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
    }

    public LocalDateTime getDataHoraFimMedicao() {
        return dataHoraFimMedicao;
    }

    public void setDataHoraFimMedicao(LocalDateTime dataHoraFimMedicao) {
        this.dataHoraFimMedicao = dataHoraFimMedicao;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public Double getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(Double duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }


    public Double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(Double valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public Double getConsumoWh() {
        return consumoWh;
    }

    public void setConsumoWh(Double consumoWh) {
        this.consumoWh = consumoWh;
    }
}
