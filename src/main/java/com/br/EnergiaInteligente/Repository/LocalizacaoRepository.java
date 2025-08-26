package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.LocalizacaoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoModel, Long> {

    Optional<LocalizacaoModel> findByCodigoPublico(String codigoPublico);

    @Query("SELECT l FROM LocalizacaoModel l WHERE l.usuario.id = :codigoPublicoUsuario")
    List<LocalizacaoModel> findLocalizacoesPorusuario(@Param("codigoPublicoUsuario") String codigoPublicoUsuario);
}
