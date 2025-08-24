package com.br.EnergiaInteligente.Model;

import com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil;
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

    @Column(name = "consumo")
    private long consumo;

    @Column(name = "tensao")
    private int tensao;

    @Column(name = "corrente")
    private int corrente;

    @ManyToOne
    @JoinColumn(name = "cdTipoMedicao")
    private TipoMedicaoModel tipoMedicao;

    @Column(name = "dataHoraInicioMedicao")
    private LocalDateTime dataHoraInicioMedicao;

    @Column(name = "dataHoraFimMedicao")
    private LocalDateTime dataHoraFimMedicao;


    //private Float fatorCorrente;  // Fator de calibração do sensor SCT-013


    public MedicaoModel() {
    }

    public MedicaoModel(long id, DispositivoModel dispositivo, long consumo, int tensao, int corrente, TipoMedicaoModel tipoMedicao, LocalDateTime dataHoraFimMedicao, LocalDateTime dataHoraInicioMedicao) {
        this.id = id;
        this.dispositivo = dispositivo;
        this.consumo = consumo;
        this.tensao = tensao;
        this.corrente = corrente;
        this.tipoMedicao = tipoMedicao;
        this.dataHoraFimMedicao = dataHoraFimMedicao;
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
        this.codigoPublico = GeradoIdentificadorUtil.generateSecureId().toUpperCase();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
    }

    public long getConsumo() {
        return consumo;
    }

    public void setConsumo(long consumo) {
        this.consumo = consumo;
    }

    public int getTensao() {
        return tensao;
    }

    public void setTensao(int tensao) {
        this.tensao = tensao;
    }

    public int getCorrente() {
        return corrente;
    }

    public void setCorrente(int corrente) {
        this.corrente = corrente;
    }

    public TipoMedicaoModel getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(TipoMedicaoModel tipoMedicao) {
        this.tipoMedicao = tipoMedicao;
    }

    public LocalDateTime getDataHoraFimMedicao() {
        return dataHoraFimMedicao;
    }

    public void setDataHoraFimMedicao(LocalDateTime dataHoraFimMedicao) {
        this.dataHoraFimMedicao = dataHoraFimMedicao;
    }

    public LocalDateTime getDataHoraInicioMedicao() {
        return dataHoraInicioMedicao;
    }

    public void setDataHoraInicioMedicao(LocalDateTime dataHoraInicioMedicao) {
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
    }

    public String getCodigoPublico() {
        return codigoPublico;
    }

    public void setCodigoPublico(String codigoPublico) {
        this.codigoPublico = codigoPublico;
    }
}
