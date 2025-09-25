package com.br.EnergiaInteligente.Controller;

import com.br.EnergiaInteligente.Dto.Request.LoginUsuarioResquestDto;
import com.br.EnergiaInteligente.Dto.Response.LoginUsuarioResponseDto;
import com.br.EnergiaInteligente.Service.AutenticacaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService authService;

    @GetMapping("/login")
    public String loginForm(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("token") != null) {
            return "redirect:/home/index";
        }
        model.addAttribute("loginRequest", new LoginUsuarioResquestDto());
        return "pages/auth/login";
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

            // Salva o token na sessão do usuário
            HttpSession session = request.getSession(true);
            session.setAttribute("token", token);
            session.setAttribute("usuarioEmail", loginRequestDto.getEmailUsuario());

            // Redireciona para a página inicial protegida
            return "redirect:/home/index";
        } catch (Exception e) {
            model.addAttribute("erro", "Usuário ou senha inválidos!");
            return "pages/auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // remove token e dados da sessão
        }
        return "redirect:/auth/login";
    }
}

