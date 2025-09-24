package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LoginUsuarioResquestDto;
import com.br.EnergiaInteligente.Dto.Response.LoginUsuarioResponseDto;
import com.br.EnergiaInteligente.Service.AutenticacaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService authService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginUsuarioResquestDto());
        return "auth/login"; // -> templates/auth/login.html
    }

    @PostMapping("/login")
    public String logar(@ModelAttribute("loginRequest") LoginUsuarioResquestDto loginRequestDto,
                        HttpServletRequest request,
                        Model model) {
        try {
            String token = authService.autenticar(
                    loginRequestDto.getEmailUsuario(),
                    loginRequestDto.getSenha(),
                    request.getRemoteAddr(),
                    request.getHeader("User-Agent")
            );

            // Aqui você poderia salvar o token na sessão
            request.getSession().setAttribute("token", token);

            // Redirecionar para a página inicial protegida
            return "redirect:/usuarios";
        } catch (Exception e) {
            model.addAttribute("erro", "Usuário ou senha inválidos!");
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("token");
        if (token != null) {
            authService.logout(token);
            request.getSession().invalidate();
        }
        return "redirect:/auth/login";
    }
}
