package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping()
    public String home(Model model) {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();


        return "pages/relatorios/indexRelatorios";
    }

}
