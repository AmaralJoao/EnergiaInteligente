package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.LocalizacaoDispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Repository.LocalizacaoDispositivoRepository;
import com.br.EnergiaInteligente.Repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocalizacaoDispositivoService {

    @Autowired
    private LocalizacaoDispositivoRepository localizacaoDispositivoRepository;
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    @Autowired
    private LocalizacaoDispositivoMapper localizacaoDispositivoMapper;

    public LocalizacaoDispositivoResponseDto cadastrarLocalizacaoDoDispositivo(LocalizacaoDispositivoRequestDto request) {

        if (request.getCodigoPublicoLocalizacaoDoDispositivo() != null){
            throw new RuntimeException("Para criar uma nova localizacao do dispositivo o Codigo Publico deve ser NULL");
        }

        DispositivoModel dispositivo = localizacaoDispositivoRepository.findByCodigoPublico(request.getCodigoPublicoDispositivo())
                .orElseThrow(()-> new RuntimeException("Dispositivo nao localizado")).getDispositivo();

        LocalizacaoModel localizacao = localizacaoRepository.findByCodigoPublico(request.getCodigoPublicoLocalizacao())
                .orElseThrow(()-> new RuntimeException("Localizacao nao localizado"));


        LocalizacaoDispositivoModel novaLocalizacaoDoDispositivo = localizacaoDispositivoMapper.requestToModel(request);
        novaLocalizacaoDoDispositivo.setLocalizacao(localizacao);
        novaLocalizacaoDoDispositivo.setDispositivo(dispositivo);
        novaLocalizacaoDoDispositivo.setDataInicio(LocalDateTime.now());
        LocalizacaoDispositivoModel salvarNovaLocalizacaoDoDispositivo = localizacaoDispositivoRepository.save(novaLocalizacaoDoDispositivo);
        return localizacaoDispositivoMapper.toDto(salvarNovaLocalizacaoDoDispositivo);
    }

    public LocalizacaoDispositivoResponseDto editarLocalizacaoDoDispositivo(LocalizacaoDispositivoRequestDto request) {
        if (request.getCodigoPublicoLocalizacaoDoDispositivo() == null){
            throw new RuntimeException("Não foi possivel localiza a localizacao do dispositivo, Codigo Publico não deve ser NULL");
        }

        LocalizacaoDispositivoModel localizacaoDispositivoAtual = localizacaoDispositivoRepository.findByCodigoPublico(request.getCodigoPublicoLocalizacaoDoDispositivo())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar localizacao do dispositivo para editar"));

        localizacaoDispositivoAtual.setDataFim(LocalDateTime.now());
        localizacaoDispositivoRepository.save(localizacaoDispositivoAtual);

        LocalizacaoDispositivoModel novaLocalizacao = localizacaoDispositivoMapper.requestToModel(request);
        novaLocalizacao.setDispositivo(localizacaoDispositivoAtual.getDispositivo());
        novaLocalizacao.setDataInicio(LocalDateTime.now());
        novaLocalizacao.setDataFim(null);
        novaLocalizacao.setId(0);
        novaLocalizacao.setCodigoPublico(null);

        LocalizacaoDispositivoModel salva = localizacaoDispositivoRepository.save(novaLocalizacao);

        return localizacaoDispositivoMapper.toDto(salva);
    }

    public LocalizacaoDispositivoResponseDto encontrarLocalizacaoAtivaDoDispositivo(String codigoPublicoDoDispositivo) {

        LocalizacaoDispositivoModel localizacaoAtivaDoDispositivo = localizacaoDispositivoRepository.findLocalizacaoAtivaByCodigoPublicoDispositivo(codigoPublicoDoDispositivo)
                .orElseThrow(() -> new RuntimeException("Dispositivo nao possui localizacao ativa"));

        return localizacaoDispositivoMapper.toDto(localizacaoAtivaDoDispositivo);
    }
}
