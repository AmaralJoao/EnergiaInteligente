package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public String home() {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }
        return "pages/home/index";
    }

    // Redirecionamentos para outras telas (exemplos)
    @GetMapping("/dashboard")
    public String dashboard() {
        return "redirect:/dashboard/consumo"; // Redireciona para dashboard real
    }

    @GetMapping("/relatorios")
    public String relatorios() {
        return "redirect:/relatorios/geracao"; // Redireciona para relatórios
    }

    @GetMapping("/configuracoes")
    public String configuracoes() {
        return "redirect:/configuracoes/sistema"; // Redireciona para configurações
    }
}
