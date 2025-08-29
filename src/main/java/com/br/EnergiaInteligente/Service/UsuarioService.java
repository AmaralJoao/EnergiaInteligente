package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.UsuarioRequestDto;
import com.br.EnergiaInteligente.Dto.Response.UsuarioResponseDto;
import com.br.EnergiaInteligente.Mapper.UsuarioMapper;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsuarioModel novoUsuario = usuarioMapper.requestToModel(usuarioRequestDto);

        novoUsuario.setSenha(passwordEncoder.encode(novoUsuario.getSenha()));

        UsuarioModel usuarioCriado = usuarioRepository.save(novoUsuario);

        return usuarioMapper.toDto(usuarioCriado);
    }
}
