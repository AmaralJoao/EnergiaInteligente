package com.br.EnergiaInteligente.Dto.Response;

import java.time.LocalDateTime;

public class MedicaoPorDispositivoResponseDto {
    private String nomeDispositivo;
    private Long consumo;
    private Integer tensao;
    private Integer corrente;
    private String tipoMedicao;
    private LocalDateTime dataHoraFimMedicao;
    private LocalDateTime dataHoraInicioMedicao;
    private String codigoPublicoDispositivo;

    public MedicaoPorDispositivoResponseDto() {
    }

    public MedicaoPorDispositivoResponseDto(String nomeDispositivo, Long consumo, Integer tensao, Integer corrente, String tipoMedicao, LocalDateTime dataHoraFimMedicao, LocalDateTime dataHoraInicioMedicao, String codigoPublicoDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
        this.consumo = consumo;
        this.tensao = tensao;
        this.corrente = corrente;
        this.tipoMedicao = tipoMedicao;
        this.dataHoraFimMedicao = dataHoraFimMedicao;
        this.dataHoraInicioMedicao = dataHoraInicioMedicao;
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public Long getConsumo() {
        return consumo;
    }

    public void setConsumo(Long consumo) {
        this.consumo = consumo;
    }

    public Integer getTensao() {
        return tensao;
    }

    public void setTensao(Integer tensao) {
        this.tensao = tensao;
    }

    public Integer getCorrente() {
        return corrente;
    }

    public void setCorrente(Integer corrente) {
        this.corrente = corrente;
    }

    public String getTipoMedicao() {
        return tipoMedicao;
    }

    public void setTipoMedicao(String tipoMedicao) {
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

    public String getCodigoPublicoDispositivo() {
        return codigoPublicoDispositivo;
    }

    public void setCodigoPublicoDispositivo(String codigoPublicoDispositivo) {
        this.codigoPublicoDispositivo = codigoPublicoDispositivo;
    }
}
