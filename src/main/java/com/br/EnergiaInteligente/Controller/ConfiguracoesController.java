package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.UsuarioResponseDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import com.br.EnergiaInteligente.Service.LocalizacaoService;
import com.br.EnergiaInteligente.Service.UsuarioService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ConfiguracoesController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private DispositivoService dispositivoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping("/config")
    public String configPage(Model model) {
        // Valida sessão
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();

        // Buscar dados do usuário
        UsuarioResponseDto usuario = usuarioService.mostrarUsuario(codigoPublicoUsuario);
        model.addAttribute("usuario", usuario);

        // Buscar localizações do usuário
        List<LocalizacaoResponseDto> localizacoes = localizacaoService.LocalizacoesPorUsuario(codigoPublicoUsuario);
        model.addAttribute("localizacoes", localizacoes);

        // Buscar dispositivos do usuário
        List<DispositivoComLocalizacaoResponseDto> dispositivos = dispositivoService.listarDispositivosPorUsuario(codigoPublicoUsuario);
        model.addAttribute("dispositivos", dispositivos);

        return "pages/home/config"; // renderiza config.html
    }
}
