package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto;
import com.br.EnergiaInteligente.Model.DispositivoModel;
import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoModel, Long> {

    DispositivoModel findByIdentificadorDispositivo(long identificadorPedido);

    DispositivoModel findByApiKey(String apiKey);

    DispositivoModel findByChipId(Long chipId);

    Optional<DispositivoModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);

    @Query("SELECT NEW com.br.EnergiaInteligente.Dto.Response.DispositivoComLocalizacaoResponseDto(" +
            "d.nomeDoDispositivo, d.modeloDispositivo, d.versaoDoDispositivo, " +
            "ld.nomeDaLocalizacaoDoDispositivo, " +
            "l.cidade, l.nomeDaRua, l.numero, l.complemento) " +
            "FROM DispositivoModel d " +
            "JOIN LocalizacaoDispositivoModel ld ON ld.dispositivo.id = d.id " +
            "JOIN LocalizacaoModel l ON ld.localizacao.id = l.id " +
            "WHERE d.usuario.codigoPublico = :codigoPublico")
    List<DispositivoComLocalizacaoResponseDto> findDispositivosCompletosByUsuario(String codigoPublico);
}
