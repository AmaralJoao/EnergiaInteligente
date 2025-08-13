package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Model.SessaoModel;
import com.br.EnergiaInteligente.Repository.SessaoRepository;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessaoRepository sessaoRepository;

    public String autenticar(String email, String senha, String ip, String userAgent){
        var usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Credenciais invalidas"));

        if (!new BCryptPasswordEncoder().matches(senha, usuario.getSenha())){
            throw new RuntimeException("Credenciais incorretas");
        }

        String token = UUID.randomUUID().toString();
        SessaoModel sessao = new SessaoModel();
        sessao.setToken(token);
        sessao.setUsuario(usuario);
        sessao.setCriadaEm(LocalDateTime.now());
        sessao.setExpiraEm(LocalDateTime.now().plusHours(1));
        sessao.setAtiva(true);
        sessao.setIp(ip);
        sessao.setUserAgent(userAgent);

        sessaoRepository.save(sessao);
        return token;
    }

    public void logout(String token) {
        sessaoRepository.findById(token).ifPresent(sessao -> {
            sessao.setAtiva(false);
            sessaoRepository.save(sessao);
        });
    }
}
