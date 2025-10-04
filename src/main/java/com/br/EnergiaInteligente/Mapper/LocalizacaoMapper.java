package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocalizacaoMapper {

    LocalizacaoMapper INSTANCE = Mappers.getMapper(LocalizacaoMapper.class);

    LocalizacaoModel requestToModel(LocalizacaoRequestDto dto);

    LocalizacaoResponseDto toDto(LocalizacaoModel model);

    void updateModelFromDto(LocalizacaoRequestDto dto, @MappingTarget LocalizacaoModel model);

}
