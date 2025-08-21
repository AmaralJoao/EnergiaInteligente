package com.br.EnergiaInteligente.Dto.Request;

import com.br.EnergiaInteligente.Model.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CadastrarDispositivoRequesDto {

    private long identificadorDispositivo;

    private String nomeDoDispositivo;

    private String modeloDispositivo;

    private long versaoDoDispositivo;

    private String macAddres;

    private long chipId;

    public long getIdentificadorDispositivo() {
        return identificadorDispositivo;
    }

    public void setIdentificadorDispositivo(long identificadorDispositivo) {
        this.identificadorDispositivo = identificadorDispositivo;
    }

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

    public String getMacAddres() {
        return macAddres;
    }

    public void setMacAddres(String macAddres) {
        this.macAddres = macAddres;
    }

    public long getChipId() {
        return chipId;
    }

    public void setChipId(long chipId) {
        this.chipId = chipId;
    }

}
