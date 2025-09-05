package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Mapper.LocalizacaoMapper;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import com.br.EnergiaInteligente.Repository.LocalizacaoRepository;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoMapper localizacaoMapper;
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    public LocalizacaoResponseDto criarLocalizacao(LocalizacaoRequestDto novaLocalizacao, String token) {

        if (novaLocalizacao.getCodigoPublicoLocalizacao() != null){
            throw new RuntimeException("para criar uma localizacao o campo Codigo Publico deve ser NULL");
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuarioPorToken(token);


        UsuarioModel usuario = usuarioRepository.findByCodigoPublico(codigoPublicoUsuario)
                .orElseThrow(() -> new RuntimeException("Erro ao identificar usuario"));
        LocalizacaoModel localizacao = localizacaoMapper.requestToModel(novaLocalizacao);
        localizacao.setUsuario(usuario);
        localizacao.setDataInicio(LocalDateTime.now());
        localizacao.setStatus(true);
        LocalizacaoModel salvarLocalizacao = localizacaoRepository.save(localizacao);

        return localizacaoMapper.toDto(salvarLocalizacao);
    }


    public LocalizacaoResponseDto editarLocalizacao(LocalizacaoRequestDto editarLocalizacaoDto) {

        if (editarLocalizacaoDto.getCodigoPublicoLocalizacao() == null){
            throw new RuntimeException("para editar uma localizacao o campo Codigo Publico não deve ser NULL");
        }

        LocalizacaoModel localizacaoAtual = localizacaoRepository.findByCodigoPublico(editarLocalizacaoDto.getCodigoPublicoLocalizacao())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar localizacao"));

        LocalizacaoModel localizacaoParaEditar = localizacaoMapper.requestToModel(editarLocalizacaoDto);

        if (localizacaoAtual.getCep().equals(localizacaoParaEditar.getCep()) &&
                localizacaoAtual.getNumero() == localizacaoParaEditar.getNumero()) {

            localizacaoMapper.updateModelFromDto(editarLocalizacaoDto, localizacaoAtual);
            LocalizacaoModel atualizada = localizacaoRepository.save(localizacaoAtual);
            return localizacaoMapper.toDto(atualizada);
        }else {

            // 1. Finaliza o registro atual
            localizacaoAtual.setDataFim(LocalDateTime.now());
            localizacaoRepository.save(localizacaoAtual);

            // 2. Cria uma nova localização com os dados editados
            LocalizacaoModel novaLocalizacao = localizacaoMapper.requestToModel(editarLocalizacaoDto);
            novaLocalizacao.setDataInicio(LocalDateTime.now());
            novaLocalizacao.setDataFim(null);
            novaLocalizacao.setId(0);
            novaLocalizacao.setCodigoPublico(null);

            LocalizacaoModel salva = localizacaoRepository.save(novaLocalizacao);

            return localizacaoMapper.toDto(salva);
        }

    }

    public List<LocalizacaoResponseDto> LocalizacoesPorUsuario(String token) {

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuarioPorToken(token);

        List<LocalizacaoModel> localizacoesDoUsuario = localizacaoRepository.findLocalizacoesPorusuario(codigoPublicoUsuario);

        return localizacoesDoUsuario.stream()
                .map(localizacaoMapper::toDto)
                .collect(Collectors.toList());
    }

}
