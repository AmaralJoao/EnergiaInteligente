package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.MedicaoRequestDto;
import com.br.EnergiaInteligente.Mapper.MedicaoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.MedicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicaoService {

    @Autowired
    private MedicaoMapper medicaoMapper;
    @Autowired
    private MedicaoRepository medicaoRepository;
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void CadastrarNovaMedicao(MedicaoRequestDto medicaoRequestDto){
        MedicaoModel novaMedicao = medicaoMapper.requestToModel(medicaoRequestDto);

        DispositivoModel dispositivo = dispositivoRepository.findByIdentificadorDispositivo(novaMedicao.getDispositivo().getIdentificadorDispositivo());
        novaMedicao.setDispositivo(dispositivo);

        medicaoRepository.save(novaMedicao);
    }
}
