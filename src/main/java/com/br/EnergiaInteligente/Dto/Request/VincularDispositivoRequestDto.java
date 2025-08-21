package com.br.EnergiaInteligente.Dto.Request;

public class VincularDispositivoRequestDto {

    private Long cdUsuario;

    private Long chipId;

    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public Long getChipId() {
        return chipId;
    }

    public void setChipId(Long chipId) {
        this.chipId = chipId;
    }
}
