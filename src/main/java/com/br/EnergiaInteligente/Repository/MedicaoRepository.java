package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicaoRepository extends JpaRepository<MedicaoModel, Long> {

    Optional<MedicaoModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);

    @Query("SELECT NEW com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto(" +
            "d.nomeDoDispositivo, m.consumo, m.tensao, m.corrente, " +
            "tm.descricao, m.dataHoraFimMedicao, m.dataHoraInicioMedicao, d.codigoPublico) " +
            "FROM MedicaoModel m " +
            "JOIN m.dispositivo d " +
            "JOIN m.tipoMedicao tm " +
            "JOIN d.usuario u " +
            "WHERE u.codigoPublico = :usuarioCodigoPublico " + // ✅ Usando código público
            "AND m.dataHoraFimMedicao BETWEEN :dataInicio AND :dataFim " +
            "ORDER BY d.nomeDoDispositivo, m.dataHoraFimMedicao DESC")
    List<MedicaoPorDispositivoResponseDto> findMedicoesPorUsuarioCodigoPublicoEPeriodo(
            @Param("usuarioCodigoPublico") String usuarioCodigoPublico, // ✅ Tipo correto: String
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);
}
