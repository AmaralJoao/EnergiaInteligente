package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.UsuarioRequestDto;
import com.br.EnergiaInteligente.Dto.Response.UsuarioResponseDto;
import com.br.EnergiaInteligente.Service.UsuarioService;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home/config")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    @GetMapping("/usuario")
    public String configuracoes(Model model) {
        if (!AutenticacaoUtils.isSessaoValida()) {
            return "redirect:/auth/login";
        }

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
        UsuarioResponseDto usuario = usuarioService.localizarPorCodigoPublico(codigoPublicoUsuario);

        model.addAttribute("usuario", usuario);
        return "pages/home/configuracoes/usuario/UsuarioConfiguracao";
    }

    @PostMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(@ModelAttribute UsuarioRequestDto usuarioRequestDto) {
        try {
            UsuarioResponseDto usuarioAtualizado = usuarioService.atualizarUsuario(usuarioRequestDto);
            return ResponseEntity.ok().body(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/alterar-senha")
    @ResponseBody
    public ResponseEntity<String> alterarSenha(@RequestParam String senhaAtual,
                                               @RequestParam String novaSenha) {
        try {
            String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuario();
            usuarioService.alterarSenha(codigoPublicoUsuario, senhaAtual, novaSenha);
            return ResponseEntity.ok().body("Senha alterada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
