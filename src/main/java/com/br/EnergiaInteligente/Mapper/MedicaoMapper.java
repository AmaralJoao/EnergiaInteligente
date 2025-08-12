package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.UsuarioRequestDto;
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

    MedicaoModel requestToModel(MedicaoRequestDto dto);

    //UsuarioResponseDto toDto(UsuarioModel model);

    void updateModelFromDto(MedicaoRequestDto dto, @MappingTarget MedicaoModel model);

}
