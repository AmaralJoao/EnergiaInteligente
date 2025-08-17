package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.DispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private DispositivoMapper dispositivoMapper;

    public String novoDispositivo(CadastrarDispositivoRequesDto dispositivoRequesDto) {

        if (dispositivoExiste(dispositivoRequesDto.getChipId())) {
            throw new RuntimeException("Dispositivo já cadastrado com este chipId");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UsuarioModel usuarioDoDispositivo = autenticacaoService.autenticarParaDispositivo(
                dispositivoRequesDto.getEmailusuario(),
                dispositivoRequesDto.getSenhaUsuario()
        );

        DispositivoModel novoDispositivel = dispositivoMapper.requestToModel(dispositivoRequesDto);
        String apiKey = generateApiKey(32);
        novoDispositivel.setApiKey(encoder.encode(apiKey));
        novoDispositivel.setUsuario(usuarioDoDispositivo);
        DispositivoModel salvarDispositivo = dispositivoRepository.save(novoDispositivel);

        return apiKey;
    }

    public static String generateApiKey(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public boolean dispositivoExiste(Long chipId) {
        return dispositivoRepository.findByChipId(chipId) != null;
    }

}
