package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicaoMapper {

    MedicaoMapper INSTANCE = Mappers.getMapper(MedicaoMapper.class);



    // Model para Response DTO
    MedicaoResponseDto toDto(MedicaoModel model);

    @AfterMapping
    default void afterToDtoMapping(@MappingTarget MedicaoResponseDto responseDto, MedicaoModel model) {
        // Mapeamento do período
        if (model.getDataHoraInicioMedicao() != null || model.getDataHoraFimMedicao() != null) {
            MedicaoResponseDto.Periodo periodo = new MedicaoResponseDto.Periodo();
            periodo.setInicio(model.getDataHoraInicioMedicao());
            periodo.setFim(model.getDataHoraFimMedicao());
            periodo.setDuracaoHoras(model.getDuracaoHoras());
            responseDto.setPeriodo(periodo);
        }

        // Mapeamento da energia
        if (model.getConsumoWh() != null || model.getConsumoKwh() != null) {
            MedicaoResponseDto.DadosEnergia energia = new MedicaoResponseDto.DadosEnergia();
            energia.setConsumoWh(model.getConsumoWh());
            energia.setConsumoKwh(model.getConsumoKwh());
            responseDto.setEnergia(energia);
        }

        // Mapeamento da potência
        if (model.getPotenciaMediaW() != null || model.getPotenciaMaximaW() != null || model.getPotenciaMinimaW() != null) {
            MedicaoResponseDto.DadosPotencia potencia = new MedicaoResponseDto.DadosPotencia();
            potencia.setMediaW(model.getPotenciaMediaW());
            potencia.setMaximaW(model.getPotenciaMaximaW());
            potencia.setMinimaW(model.getPotenciaMinimaW());
            responseDto.setPotencia(potencia);
        }

        // Mapeamento da corrente
        if (model.getCorrenteMediaA() != null || model.getCorrenteMaximaA() != null || model.getCorrenteMinimaA() != null) {
            MedicaoResponseDto.DadosCorrente corrente = new MedicaoResponseDto.DadosCorrente();
            corrente.setMediaA(model.getCorrenteMediaA());
            corrente.setMaximaA(model.getCorrenteMaximaA());
            corrente.setMinimaA(model.getCorrenteMinimaA());
            responseDto.setCorrente(corrente);
        }

        // Mapeamento da qualidade
        if (model.getContagemMedicoes() != null || model.getCompletudeDados() != null) {
            MedicaoResponseDto.DadosQualidade qualidade = new MedicaoResponseDto.DadosQualidade();
            qualidade.setContagemMedicoes(model.getContagemMedicoes());
            qualidade.setCompletudeDados(model.getCompletudeDados());
            responseDto.setQualidade(qualidade);
        }

        // Mapeamento do custo (calculado)
        if (model.getValorTarifa() != null || model.getCustoTotal() != null) {
            MedicaoResponseDto.CalculoCusto custo = new MedicaoResponseDto.CalculoCusto();
            custo.setValorTarifa(model.getValorTarifa());
            custo.setCustoTotal(model.getCustoTotal());
            custo.setMoeda("BRL");

            // Determina tipo de tarifa baseado no valor
            if (model.getValorTarifa() != null) {
                if (model.getValorTarifa() >= 0.75) {
                    custo.setTipoTarifa("ponta");
                } else if (model.getValorTarifa() >= 0.45) {
                    custo.setTipoTarifa("fora_ponta");
                } else {
                    custo.setTipoTarifa("fim_semana");
                }
            }

            responseDto.setCusto(custo);
        }
    }

    // Update para casos de atualização
    //void updateModelFromDto(NovaMedicaoRequestDto dto, @MappingTarget MedicaoModel model);
}