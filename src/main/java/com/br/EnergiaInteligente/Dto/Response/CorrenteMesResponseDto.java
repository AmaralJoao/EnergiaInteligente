package com.br.EnergiaInteligente.Dto.Response;

public class CorrenteMesResponseDto {

    private Double correnteMaxima;
    private Double correnteMinima;

    public CorrenteMesResponseDto(Double correnteMaxima, Double correnteMinima) {
        this.correnteMaxima = correnteMaxima;
        this.correnteMinima = correnteMinima;
    }

    // getters e setters
    public Double getCorrenteMaxima() { return correnteMaxima; }
    public void setCorrenteMaxima(Double correnteMaxima) { this.correnteMaxima = correnteMaxima; }

    public Double getCorrenteMinima() { return correnteMinima; }
    public void setCorrenteMinima(Double correnteMinima) { this.correnteMinima = correnteMinima; }

}
