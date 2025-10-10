package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LocalizacaoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Service.LocalizacaoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/home/config")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping("/localizacao")
    public String home(Model model) {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        List<LocalizacaoResponseDto> localizacoes = localizacaoService.LocalizacoesPorUsuario(codigoPublicoUsuario);

        model.addAttribute("localizacoes", localizacoes);
        return "pages/home/configuracoes/localizacao/localizacoesUsuario";
    }

    @PostMapping("/novalocalizacao")
    @ResponseBody
    public ResponseEntity<LocalizacaoResponseDto> cadastrarNovaLocalizacao(@ModelAttribute LocalizacaoRequestDto localizacaoRequestDto){
        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        LocalizacaoResponseDto novaLocalizacao = localizacaoService.criarLocalizacao(localizacaoRequestDto, codigoPublicoUsuario);
        return ResponseEntity.ok().body(novaLocalizacao);
    }

    @PostMapping("/editar")
    @ResponseBody
    public ResponseEntity<LocalizacaoResponseDto> editarLocalizacao(@ModelAttribute LocalizacaoRequestDto localizacaoRequestDto){
        LocalizacaoResponseDto localizacaoEditada = localizacaoService.editarLocalizacao(localizacaoRequestDto);
        return ResponseEntity.ok().body(localizacaoEditada);
    }

    @GetMapping("/localizacoes")
    @ResponseBody
    public ResponseEntity<List<LocalizacaoResponseDto>> listarLocalizacoesPorUsuario(){
        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        List<LocalizacaoResponseDto> localizacoes = localizacaoService.LocalizacoesPorUsuario(codigoPublicoUsuario);
        return ResponseEntity.ok().body(localizacoes);
    }

}