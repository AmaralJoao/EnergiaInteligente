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

    private long cdUsuario;

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

    public long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
