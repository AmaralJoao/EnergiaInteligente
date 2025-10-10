package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoDispositivoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.LocalizacaoResponseDto;
import com.br.EnergiaInteligente.Service.DispositivoService;
import com.br.EnergiaInteligente.Service.LocalizacaoDispositivoService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home/config")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @Autowired
    private LocalizacaoDispositivoService localizacaoDispositivoService;

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping("/dispositivo")
    public String home(Model model) {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        List<DispositivoComLocalizacaoResponseDto> dispositivos = dispositivoService.listarDispositivosPorUsuario(codigoPublicoUsuario);

        System.out.println("Dispositivos encontrados: " + dispositivos.size());

        model.addAttribute("dispositivos", dispositivos);
        return "pages/home/configuracoes/dispositivo/dispositivosUsuario";
    }

    @GetMapping("/dispositivo/{id}")
    @ResponseBody
    public DispositivoResponseDto getDispositivoById(@PathVariable Long id) {
        return dispositivoService.listarPorId(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo não encontrado"));
    }

    @GetMapping("/dispositivo/{id}/localizacoes")
    @ResponseBody
    public List<LocalizacaoDispositivoResponseDto> getLocalizacoesDispositivo(@PathVariable Long id) {
        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        return localizacaoDispositivoService.localizacoesAntigasDoDispositivo(codigoPublicoUsuario)
                .stream()
                .filter(localizacao -> localizacao.getIdDispositivo().equals(id))
                .collect(Collectors.toList());
    }

    @PostMapping("/vincular")
    @ResponseBody
    public ResponseEntity<List<LocalizacaoResponseDto>> vincularDispositivo(@RequestParam Long chipId){
        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        dispositivoService.vincularDispositivoUsuario(chipId, codigoPublicoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
