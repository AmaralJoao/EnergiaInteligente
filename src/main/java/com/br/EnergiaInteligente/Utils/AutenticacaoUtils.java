package com.br.EnergiaInteligente.Utils;

import com.br.EnergiaInteligente.Repository.SessaoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class AutenticacaoUtils {

    private final SessaoRepository sessaoRepository;

    @Autowired
    public AutenticacaoUtils(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }


    public static String getTokenSessao() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                return (String) session.getAttribute("token");
            }
        }
        return null;
    }

    public static String getUsuarioEmail() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                return (String) session.getAttribute("usuarioEmail");
            }
        }
        return null;
    }

    public String getCodigoPublicoUsuario() {
        String token = AutenticacaoUtils.getTokenSessao();
        if (token == null) {
            throw new RuntimeException("Sessão inválida ou expirada");
        }

        return sessaoRepository.findCodigoPublicoByToken(token);
    }

    public static boolean isSessaoValida() {
        return getTokenSessao() != null;
    }


    private static HttpServletRequest getRequest() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (attr != null ? attr.getRequest() : null);
    }
}
