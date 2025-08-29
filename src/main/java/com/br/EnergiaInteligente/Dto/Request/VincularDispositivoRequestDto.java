package com.br.EnergiaInteligente.Dto.Request;

public class VincularDispositivoRequestDto {

    private Long codigoPublicoUsuario;

    private Long chipId;

    public Long getCdUsuario() {
        return codigoPublicoUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.codigoPublicoUsuario = cdUsuario;
    }

    public Long getChipId() {
        return chipId;
    }

    public void setChipId(Long chipId) {
        this.chipId = chipId;
    }
}
