package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocalizacaoDispositivoMapper {

    LocalizacaoDispositivoMapper INSTANCE = Mappers.getMapper(LocalizacaoDispositivoMapper.class);

    LocalizacaoDispositivoModel requestToModel(LocalizacaoDispositivoRequestDto dto);

    LocalizacaoDispositivoResponseDto toDto(LocalizacaoDispositivoModel model);

    void updateModelFromDto(LocalizacaoDispositivoRequestDto dto, @MappingTarget LocalizacaoDispositivoModel model);
}
