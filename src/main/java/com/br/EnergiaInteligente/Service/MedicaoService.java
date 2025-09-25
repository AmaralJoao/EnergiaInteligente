package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.LocalizarMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Request.NovaMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.MedicaoResponseDto;
import com.br.EnergiaInteligente.Mapper.MedicaoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.MedicaoRepository;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicaoService {

    @Autowired
    private MedicaoMapper medicaoMapper;
    @Autowired
    private MedicaoRepository medicaoRepository;
    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private DispositivoService dispositivoService;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    public void cadastrarNovaMedicao(NovaMedicaoRequestDto medicaoRequestDto, String apiKey){

        if (!dispositivoService.apiKeyIsValida(apiKey)){
            throw new RuntimeException("Api key nao é valida");
        }

        MedicaoModel novaMedicao = medicaoMapper.requestToModel(medicaoRequestDto);

        DispositivoModel dispositivo = dispositivoRepository.findByApiKey(apiKey);
        novaMedicao.setDispositivo(dispositivo);

        medicaoRepository.save(novaMedicao);
    }

    public List<MedicaoPorDispositivoResponseDto> listarMedicoesPorUsuario(LocalizarMedicaoRequestDto request, String token) {

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        return medicaoRepository.findMedicoesPorUsuarioCodigoPublicoEPeriodo(codigoPublicoUsuario, request.getDataInicio(), request.getDataFim());
    }

    public List<MedicaoResponseDto>listarMedicoesDoDispositivo(String apikey ){
       List<MedicaoModel> mediicoes = medicaoRepository.findByDispositivoApikey(apikey);

        return mediicoes.stream()
                .map(medicaoMapper::toDto)
                .collect(Collectors.toList());
    }
}
