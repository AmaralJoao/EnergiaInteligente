package com.br.EnergiaInteligente.Dto.Response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DispositivoResponseDto {

    private Long id;
    private String nomeDoDispositivo;
    private String modeloDispositivo;
    private long versaoDoDispositivo;
    private LocalizacaoDispositivoResponseDto localizacaoDispositivo;
    private LocalizacaoResponseDto localizacao;

}
