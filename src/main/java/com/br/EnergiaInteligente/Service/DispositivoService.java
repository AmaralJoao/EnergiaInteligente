package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.DispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DispositivoMapper dispositivoMapper;

    public DispositivoResponseDto novoDispositivo(CadastrarDispositivoRequesDto dispositivoRequesDto) {
        UsuarioModel usuarioDoDispositivo = usuarioRepository.findById(dispositivoRequesDto.getCdUsuario())
                .orElseThrow(()-> new RuntimeException("usuario nao existente"));

        DispositivoModel novoDispositivel = dispositivoMapper.requestToModel(dispositivoRequesDto);
        novoDispositivel.setUsuario(usuarioDoDispositivo);

        DispositivoModel salvarDispositivo = dispositivoRepository.save(novoDispositivel);

        return dispositivoMapper.toDto(salvarDispositivo);
    }

}
