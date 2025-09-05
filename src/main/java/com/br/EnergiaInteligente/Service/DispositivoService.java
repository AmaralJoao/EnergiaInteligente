package com.br.EnergiaInteligente.Service;

import com.br.EnergiaInteligente.Dto.Request.CadastrarDispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.DispositivoRequesDto;
import com.br.EnergiaInteligente.Dto.Request.VincularDispositivoRequestDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Dto.Response.DispositivoResponseDto;
import com.br.EnergiaInteligente.Mapper.DispositivoMapper;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import com.br.EnergiaInteligente.Repository.DispositivoRepository;
import com.br.EnergiaInteligente.Repository.UsuarioRepository;
import com.br.EnergiaInteligente.Utils.AutenticacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private DispositivoMapper dispositivoMapper;
    @Autowired
    private AutenticacaoUtils autenticacaoUtils;

    public String novoDispositivo(CadastrarDispositivoRequesDto dispositivoRequesDto) {

        if (dispositivoExiste(dispositivoRequesDto.getChipId())) {
            throw new RuntimeException("Dispositivo já cadastrado com este chipId");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        DispositivoModel novoDispositivel = dispositivoMapper.requestToModel(dispositivoRequesDto);
        String apiKey = generateApiKey(32);
        novoDispositivel.setApiKey(encoder.encode(apiKey));
        DispositivoModel salvarDispositivo = dispositivoRepository.save(novoDispositivel);

        return apiKey;
    }

    public DispositivoResponseDto listarPorChipId(Long chipId){
        DispositivoModel dispositivo = dispositivoRepository.findByChipId(chipId);
        return dispositivoMapper.toDto(dispositivo);
    }

    public DispositivoResponseDto vincularDispositivoUsuario(VincularDispositivoRequestDto vincularDispositivoRequestDto, String token){
        String codigoPublicousuario = autenticacaoUtils.getCodigoPublicoUsuarioPorToken(token);

        DispositivoModel dispositivo = dispositivoRepository.findByChipId(vincularDispositivoRequestDto.getChipId());
        UsuarioModel usuarioDispositivo = usuarioRepository.findByCodigoPublico(codigoPublicousuario).orElseThrow();

        dispositivo.setUsuario(usuarioDispositivo);

        return dispositivoMapper.toDto(dispositivoRepository.save(dispositivo));
    }

    public static String generateApiKey(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public boolean apiKeyIsValida(String apiKey){
        return true;
    }

    public boolean dispositivoExiste(Long chipId) {
        return dispositivoRepository.findByChipId(chipId) != null;
    }

    public List<DispositivoComLocalizacaoResponseDto> listarDispositivosPorUsuario(String token) {

        String codigoPublicoUsuario = autenticacaoUtils.getCodigoPublicoUsuarioPorToken(token);

        return dispositivoRepository.findDispositivosCompletosByUsuario(codigoPublicoUsuario);
    }

    public DispositivoResponseDto editarDispositivo(DispositivoRequesDto dispositivoRequesDto) {
        return null;
    }
}
