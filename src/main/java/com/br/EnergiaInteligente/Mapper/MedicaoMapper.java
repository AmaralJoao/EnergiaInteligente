package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.NovaMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.UsuarioRequestDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicaoMapper {

    MedicaoMapper INSTANCE = Mappers.getMapper(MedicaoMapper.class);


    // Para novas medicoes
    MedicaoModel requestToModel(NovaMedicaoRequestDto dto);

    MedicaoResponseDto toDto(MedicaoModel model);

    void updateModelFromDto(NovaMedicaoRequestDto dto, @MappingTarget MedicaoModel model);



}
