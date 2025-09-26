package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocalizacaoDispositivoMapper {

    LocalizacaoDispositivoMapper INSTANCE = Mappers.getMapper(LocalizacaoDispositivoMapper.class);

    //@Mapping(source = "codigoPublico", target = "codigoPublicoLocalizacaoDoDispositivo")
    //@Mapping(source = "nomeDaLocalizacaoDoDispositivo", target = "nomeDaLocalizacaoDoDispositivo")
    LocalizacaoDispositivoResponseDto toDto(LocalizacaoDispositivoModel model);

    @Mapping(target = "codigoPublico", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "localizacao", ignore = true)
    @Mapping(target = "dispositivo", ignore = true)
    @Mapping(target = "dataInicio", ignore = true)
    @Mapping(target = "dataFim", ignore = true)
    LocalizacaoDispositivoModel requestToModel(LocalizacaoDispositivoRequestDto dto);

    void updateModelFromDto(LocalizacaoDispositivoRequestDto dto, @MappingTarget LocalizacaoDispositivoModel model);
}
