package com.br.EnergiaInteligente.Dto.Response;

import java.time.LocalDateTime;

public class MedicaoResponseDto {
    private Periodo periodo;
    private DadosEnergia energia;
    private DadosPotencia potencia;
    private DadosCorrente corrente;
    private DadosQualidade qualidade;
    private CalculoCusto custo;

    // Classes Internas
    public static class Periodo {
        private LocalDateTime inicio;
        private LocalDateTime fim;
        private Double duracaoHoras;

        public LocalDateTime getInicio() { return inicio; }
        public void setInicio(LocalDateTime inicio) { this.inicio = inicio; }

        public LocalDateTime getFim() { return fim; }
        public void setFim(LocalDateTime fim) { this.fim = fim; }

        public Double getDuracaoHoras() { return duracaoHoras; }
        public void setDuracaoHoras(Double duracaoHoras) { this.duracaoHoras = duracaoHoras; }
    }

    public static class DadosEnergia {
        private Double consumoWh;
        private Double consumoKwh;

        public Double getConsumoWh() { return consumoWh; }
        public void setConsumoWh(Double consumoWh) { this.consumoWh = consumoWh; }

        public Double getConsumoKwh() { return consumoKwh; }
        public void setConsumoKwh(Double consumoKwh) { this.consumoKwh = consumoKwh; }
    }

    public static class DadosPotencia {
        private Double mediaW;
        private Double maximaW;
        private Double minimaW;

        public Double getMediaW() { return mediaW; }
        public void setMediaW(Double mediaW) { this.mediaW = mediaW; }

        public Double getMaximaW() { return maximaW; }
        public void setMaximaW(Double maximaW) { this.maximaW = maximaW; }

        public Double getMinimaW() { return minimaW; }
        public void setMinimaW(Double minimaW) { this.minimaW = minimaW; }
    }

    public static class DadosCorrente {
        private Double mediaA;
        private Double maximaA;
        private Double minimaA;

        public Double getMediaA() { return mediaA; }
        public void setMediaA(Double mediaA) { this.mediaA = mediaA; }

        public Double getMaximaA() { return maximaA; }
        public void setMaximaA(Double maximaA) { this.maximaA = maximaA; }

        public Double getMinimaA() { return minimaA; }
        public void setMinimaA(Double minimaA) { this.minimaA = minimaA; }
    }

    public static class DadosQualidade {
        private Integer contagemMedicoes;
        private Double completudeDados;

        public Integer getContagemMedicoes() { return contagemMedicoes; }
        public void setContagemMedicoes(Integer contagemMedicoes) { this.contagemMedicoes = contagemMedicoes; }

        public Double getCompletudeDados() { return completudeDados; }
        public void setCompletudeDados(Double completudeDados) { this.completudeDados = completudeDados; }
    }

    public static class CalculoCusto {
        private String tipoTarifa;
        private Double valorTarifa;
        private Double custoTotal;
        private String moeda;

        public String getTipoTarifa() { return tipoTarifa; }
        public void setTipoTarifa(String tipoTarifa) { this.tipoTarifa = tipoTarifa; }

        public Double getValorTarifa() { return valorTarifa; }
        public void setValorTarifa(Double valorTarifa) { this.valorTarifa = valorTarifa; }

        public Double getCustoTotal() { return custoTotal; }
        public void setCustoTotal(Double custoTotal) { this.custoTotal = custoTotal; }

        public String getMoeda() { return moeda; }
        public void setMoeda(String moeda) { this.moeda = moeda; }
    }

    public Periodo getPeriodo() { return periodo; }
    public void setPeriodo(Periodo periodo) { this.periodo = periodo; }

    public DadosEnergia getEnergia() { return energia; }
    public void setEnergia(DadosEnergia energia) { this.energia = energia; }

    public DadosPotencia getPotencia() { return potencia; }
    public void setPotencia(DadosPotencia potencia) { this.potencia = potencia; }

    public DadosCorrente getCorrente() { return corrente; }
    public void setCorrente(DadosCorrente corrente) { this.corrente = corrente; }

    public DadosQualidade getQualidade() { return qualidade; }
    public void setQualidade(DadosQualidade qualidade) { this.qualidade = qualidade; }

    public CalculoCusto getCusto() { return custo; }
    public void setCusto(CalculoCusto custo) { this.custo = custo; }

}
