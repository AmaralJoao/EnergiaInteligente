package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.LocalizarMedicaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.*;
import com.br.EnergiaInteligente.Mapper.MedicaoMapper;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.MedicaoRepository;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
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

    public List<MedicaoPorDispositivoResponseDto> listarMedicoesPorUsuario(LocalizarMedicaoRequestDto request, String token) {

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        return null; //medicaoRepository.findMedicoesPorUsuarioCodigoPublicoEPeriodo(codigoPublicoUsuario, request.getDataInicio(), request.getDataFim());
    }

    public List<MedicaoResponseDto>listarMedicoesDoDispositivo(String apikey ){
       List<MedicaoModel> mediicoes = medicaoRepository.findByDispositivoApikey(apikey);

        return mediicoes.stream()
                .map(medicaoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TotalMedicaoPorMesResponseDto> consumoPorMes(String codigoPublicoUsuario){

        return medicaoRepository.findTotalMedicoesMensaisByCodigoPublico(codigoPublicoUsuario);

    }

    public TotalMedicaoDiaMesResponseDto getContagemMedicoesPorDia(String codigoPublico) {
        return medicaoRepository.findMedicoesPorPeriodo(codigoPublico, LocalDateTime.now(),LocalDateTime.now());
    }

    public TotalMedicaoDiaMesResponseDto getContagemMedicoesDoMes(String codigoPublico) {
        LocalDate hoje = LocalDate.now();

        LocalDateTime inicioMes = hoje.with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay();

        LocalDateTime fimMes = hoje.with(TemporalAdjusters.lastDayOfMonth())
                .atTime(23, 59, 59);

        return medicaoRepository.findMedicoesPorPeriodo(codigoPublico, inicioMes, fimMes);
    }

    public CorrenteMesResponseDto getCorrenteMaxMinMesAtual(String codigoPublico) {
        return medicaoRepository.findCorrenteMaxMinMesAtual(codigoPublico);
    }

    public List<MedicaoResumoResponseDto> getTop5MedicoesPorConsumo(String codigoPublico) {
        Pageable top5 = PageRequest.of(0, 5);
        return medicaoRepository.findTop5MedicoesPorConsumo(codigoPublico, top5);
    }
}
