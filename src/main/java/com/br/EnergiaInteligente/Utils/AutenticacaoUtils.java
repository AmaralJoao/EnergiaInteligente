package com.br.EnergiaInteligente.Utils;


import com.br.EnergiaInteligente.Repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class AutenticacaoUtils {

    @Autowired
    private SessaoRepository sessaoRepository;

    public String getCodigoPublicoUsuarioPorToken(String token){

        return sessaoRepository.findCodigoPublicoByToken(token);

    }

}
