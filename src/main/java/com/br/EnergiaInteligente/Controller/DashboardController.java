package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Response.TotalMedicaoPorMesResponseDto;
import com.br.EnergiaInteligente.Dto.Response.TotalMedicaoDiaMesResponseDto;
import com.br.EnergiaInteligente.Service.MedicaoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private MedicaoService medicaoService;

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping
    public String home(Model model) {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        // --- consumo por mês ---
        List<TotalMedicaoPorMesResponseDto> consumoPorMes = medicaoService.consumoPorMes(codigoPublicoUsuario);

        List<String> meses = consumoPorMes.stream()
                .map(TotalMedicaoPorMesResponseDto::getMes)
                .toList();

        List<BigDecimal> consumos = consumoPorMes.stream()
                .map(TotalMedicaoPorMesResponseDto::getConsumoTotalKwh)
                .toList();

        List<BigDecimal> custos = consumoPorMes.stream()
                .map(TotalMedicaoPorMesResponseDto::getCustoTotalMes)
                .toList();
        model.addAttribute("meses", meses);
        model.addAttribute("consumos", consumos);
        model.addAttribute("custos", custos);



        // --- contagem de medições por dia ---
        TotalMedicaoDiaMesResponseDto totalMes = medicaoService.getContagemMedicoesDoMes(codigoPublicoUsuario);

        model.addAttribute("totalValor", totalMes.getTotalValor());
        model.addAttribute("totalHoras", totalMes.getTotalHoras());
        model.addAttribute("consumoTotalKwh", totalMes.getConsumoTotalKwh());


        return "pages/dashboard/index";
    }
}

