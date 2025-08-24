package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizacaoDispositivoRepository extends JpaRepository<LocalizacaoDispositivoModel, Long> {

    Optional<LocalizacaoDispositivoModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);

    @Query("SELECT l FROM LocalizacaoDispositivoModel l WHERE l.dispositivo.codigoPublico = :codigoPublico")
    Optional<LocalizacaoDispositivoModel> findByCodigoPublicoDispositivo(@Param("codigoPublico") String codigoPublicoDoDispositivo);

    @Query("SELECT l FROM LocalizacaoDispositivoModel l WHERE l.dispositivo.codigoPublico = :codigoPublico AND l.dataFim IS NULL")
    Optional<LocalizacaoDispositivoModel> findLocalizacaoAtivaByCodigoPublicoDispositivo(@Param("codigoPublico") String codigoPublicoDoDispositivo);

    Optional<LocalizacaoDispositivoModel> findByDispositivoCodigoPublico(String codigoPublico);
}
