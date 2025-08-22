package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.LocalizacaoDispositivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizacaoDispositivoRepository extends JpaRepository<LocalizacaoDispositivoModel, Long> {

    Optional<LocalizacaoDispositivoModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);
}
