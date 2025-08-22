package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.LocalizacaoDispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import com.br.EnergiaInteligente.Repository.LocalizacaoDispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocalizacaoDispositivoService {

    @Autowired
    private LocalizacaoDispositivoRepository localizacaoDispositivoRepository;
    @Autowired
    private LocalizacaoDispositivoMapper localizacaoDispositivoMapper;

    public LocalizacaoDispositivoResponseDto cadastrarLocalizacao(LocalizacaoDispositivoRequestDto request) {

        DispositivoModel dispositivo = localizacaoDispositivoRepository.findByCodigoPublico(request.getCodigoPublicoDispositivo())
                .orElseThrow(()-> new RuntimeException("Dispositivo nao localizado")).getDispositivo();

        LocalizacaoDispositivoModel novaLocalizacao = localizacaoDispositivoMapper.requestToModel(request);
        novaLocalizacao.setDispositivo(dispositivo);
        novaLocalizacao.setDataInicio(LocalDateTime.now());
        LocalizacaoDispositivoModel salvarNovaLocalizacao = localizacaoDispositivoRepository.save(novaLocalizacao);
        return localizacaoDispositivoMapper.toDto(salvarNovaLocalizacao);
    }

    public LocalizacaoDispositivoResponseDto editarLocalizacao(LocalizacaoDispositivoRequestDto request) {
        if (request == null) {
            throw new RuntimeException("localizacao deve ser preenchida");
        }

        LocalizacaoDispositivoModel localizacaoAtual = localizacaoDispositivoRepository
                .findByCodigoPublico(request.getCodigoPublicoLocalizacao())
                .orElseThrow(() -> new RuntimeException("Erro, nao foi possivel localizar a localizacao do dispositivo"));

        LocalizacaoDispositivoModel localizacaoParaEditar = localizacaoDispositivoMapper.requestToModel(request);

        if (localizacaoAtual.getCep().equals(localizacaoParaEditar.getCep()) &&
                localizacaoAtual.getNumero() == localizacaoParaEditar.getNumero()) {

            localizacaoDispositivoMapper.updateModelFromDto(request, localizacaoAtual);
            LocalizacaoDispositivoModel atualizada = localizacaoDispositivoRepository.save(localizacaoAtual);
            return localizacaoDispositivoMapper.toDto(atualizada);

        } else {

            // 1. Finaliza o registro atual
            localizacaoAtual.setDataFim(LocalDateTime.now());
            localizacaoDispositivoRepository.save(localizacaoAtual);

            // 2. Cria uma nova localização com os dados editados
            LocalizacaoDispositivoModel novaLocalizacao = localizacaoDispositivoMapper.requestToModel(request);
            novaLocalizacao.setDispositivo(localizacaoAtual.getDispositivo()); // Mantém o mesmo dispositivo
            novaLocalizacao.setDataInicio(LocalDateTime.now());
            novaLocalizacao.setDataFim(null); // Novo registro ativo
            novaLocalizacao.setId(0); // Garante que será um novo registro
            novaLocalizacao.setCodigoPublico(null); // Será gerado automaticamente pelo @PrePersist

            // 3. Salva a nova localização
            LocalizacaoDispositivoModel salva = localizacaoDispositivoRepository.save(novaLocalizacao);

            return localizacaoDispositivoMapper.toDto(salva);
        }
    }
}
