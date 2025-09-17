package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.LocalizacaoDispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.LocalizacaoDispositivoRepository;
import com.br.EnergiaInteligente.Repository.LocalizacaoRepository;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizacaoDispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private LocalizacaoDispositivoRepository localizacaoDispositivoRepository;
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    @Autowired
    private LocalizacaoDispositivoMapper localizacaoDispositivoMapper;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    public LocalizacaoDispositivoResponseDto cadastrarLocalizacaoDoDispositivo(LocalizacaoDispositivoRequestDto request) {

        if (request.getCodigoPublicoLocalizacaoDoDispositivo() != null){
            throw new RuntimeException("Para criar uma nova localizacao dispositivo o Codigo Publico deve ser NULL");
        }

        DispositivoModel dispositivo = dispositivoRepository.findByCodigoPublico(request.getCodigoPublicoDispositivo())
                .orElseThrow(() -> new RuntimeException("Erro ao localizar dispositivo"));

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
        if (request.getCodigoPublicoLocalizacaoDoDispositivo() == null) {
            throw new RuntimeException("Não foi possivel localizar a localizacao do dispositivo, Codigo Publico não deve ser NULL");
        }

        // 1. Encerrar registro atual
        LocalizacaoDispositivoModel localizacaoDispositivoAtual = localizacaoDispositivoRepository
                .findByCodigoPublico(request.getCodigoPublicoLocalizacaoDoDispositivo())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar localizacao do dispositivo para editar"));

        localizacaoDispositivoAtual.setDataFim(LocalDateTime.now());
        localizacaoDispositivoRepository.save(localizacaoDispositivoAtual);

        // 2. Criar novo registro usando mapper MAS resetando campos críticos
        LocalizacaoDispositivoModel novaLocalizacao = localizacaoDispositivoMapper.requestToModel(request);

        // Manter relações do registro anterior
        novaLocalizacao.setDispositivo(localizacaoDispositivoAtual.getDispositivo());
        novaLocalizacao.setLocalizacao(localizacaoDispositivoAtual.getLocalizacao());

        // Sobrescrever campos temporais
        novaLocalizacao.setDataInicio(LocalDateTime.now());
        novaLocalizacao.setDataFim(null);

        // Garantir que será uma nova entidade
        novaLocalizacao.setId(0L);
        novaLocalizacao.setCodigoPublico(null); // Será gerado pelo @PrePersist

        // 3. Salvar novo registro
        LocalizacaoDispositivoModel salva = localizacaoDispositivoRepository.save(novaLocalizacao);

        return localizacaoDispositivoMapper.toDto(salva);
    }

    public List<LocalizacaoDispositivoResponseDto> localizacoesAntigasDoDispositivo(String token) {

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuarioPorToken(token);

        List<LocalizacaoDispositivoModel> localizacoesAntigasDoDispositivo = Collections.singletonList(localizacaoDispositivoRepository.findByCodigoPublicoUsuario(codigoPublicoUsuario)
                .orElseThrow(() -> new RuntimeException("usuario não possui historico de localizacoes em seus dispositivos")));

        return localizacoesAntigasDoDispositivo.stream()
                .map(localizacaoDispositivoMapper::toDto)
                .collect(Collectors.toList());
    }

}
