package com.br.EnergiaInteligente.Utils;


import com.br.EnergiaInteligente.Repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;

public class AutenticacaoUtils {

    @Autowired
    private SessaoRepository sessaoRepository;

    public String getCodigoPublicoUsuarioPorToken(String token){
        return  sessaoRepository.findCodigoPublicoByToken(token);
    }

}
