package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.UsuarioRequestDto;
import com.br.EnergiaInteligente.Dto.Response.UsuarioResponseDto;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioModel requestToModel(UsuarioRequestDto dto);

    UsuarioResponseDto toDto(UsuarioModel model);

    void updateModelFromDto(UsuarioRequestDto dto, @MappingTarget UsuarioModel model);

}
