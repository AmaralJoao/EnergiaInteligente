package com.br.EnergiaInteligente.Mapper;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoIdentificadoResposeDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DispositivoMapper {

    DispositivoMapper INSTANCE = Mappers.getMapper(DispositivoMapper.class);

    //DispositivoModel requestToModel(DispositivoRequesDto dto);

    DispositivoModel requestToModel(CadastrarDispositivoRequesDto dto);

    DispositivoResponseDto toDto(DispositivoModel model);

    // Mapper do DispositivoIdentificadoResposeDto
    DispositivoIdentificadoResposeDto dispositivoIdentificadoResposeDto(DispositivoModel model);

    //void updateModelFromDto(DispositivoRequesDto dto, @MappingTarget DispositivoModel model);
    void updateModelFromDto(CadastrarDispositivoRequesDto dto, @MappingTarget DispositivoModel model);

}
