package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Dto.Response.*;
import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicaoRepository extends JpaRepository<MedicaoModel, Long> {

    Optional<MedicaoModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);

    /*@Query("SELECT NEW com.br.EnergiaInteligente.Dto.Response.MedicaoPorDispositivoResponseDto(" +
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
            @Param("dataFim") LocalDateTime dataFim);*/


    @Query("SELECT m FROM MedicaoModel m JOIN m.dispositivo d WHERE d.apiKey = :apikey")
    List<MedicaoModel> findByDispositivoApikey(@Param("apikey") String apiKey);


    @Query("""
                SELECT 
                    FUNCTION('to_char', m.dataHoraInicioMedicao, 'FMMonth') AS mes,
                    SUM(m.consumoKwh) AS consumoTotalKwh,
                    SUM(m.duracaoHoras) AS horasMedidas,
                    SUM(m.custoTotal) AS custoTotalMes
                FROM MedicaoModel m
                JOIN m.dispositivo d
                JOIN d.usuario u
                WHERE u.codigoPublico = :codigoPublico
                GROUP BY FUNCTION('to_char', m.dataHoraInicioMedicao, 'FMMonth')
                ORDER BY MIN(m.dataHoraInicioMedicao)
            """)
    List<TotalMedicaoPorMesResponseDto> findTotalMedicoesMensaisByCodigoPublico(@Param("codigoPublico") String codigoPublico);

    @Query("""
            SELECT 
                SUM(m.consumoKwh) AS consumoTotalKwh,
                SUM(m.custoTotal) AS totalValor,
                SUM(m.duracaoHoras) AS totalHoras
            FROM MedicaoModel m
            JOIN m.dispositivo d
            JOIN d.usuario u
            WHERE u.codigoPublico = :codigoPublico
                AND m.dataHoraInicioMedicao BETWEEN :dataInicio AND :dataFim
            """)
    TotalMedicaoDiaMesResponseDto findMedicoesPorPeriodo(@Param("codigoPublico") String codigoPublico, @Param("dataInicio") LocalDateTime dataInicio,
                                                         @Param("dataFim") LocalDateTime dataFim);

    @Query("""
                SELECT new com.br.EnergiaInteligente.Dto.Response.MedicaoResumoResponseDto(
                    m.dataHoraInicioMedicao,
                    m.consumoKwh
                )
                FROM MedicaoModel m
                JOIN m.dispositivo d
                JOIN d.usuario u
                WHERE u.codigoPublico = :codigoPublico
                ORDER BY m.consumoKwh DESC
            """)
    List<MedicaoResumoResponseDto> findTop5MedicoesPorConsumo(@Param("codigoPublico") String codigoPublico, Pageable pageable);

    @Query("""
                SELECT new com.br.EnergiaInteligente.Dto.Response.CorrenteMesResponseDto(
                    MAX(m.correnteMaximaA),
                    MIN(m.correnteMinimaA)
                )
                FROM MedicaoModel m
                JOIN m.dispositivo d
                JOIN d.usuario u
                WHERE u.codigoPublico = :codigoPublico
                  AND FUNCTION('MONTH', m.dataHoraInicioMedicao) = FUNCTION('MONTH', CURRENT_DATE)
                  AND FUNCTION('YEAR', m.dataHoraInicioMedicao) = FUNCTION('YEAR', CURRENT_DATE)
            """)
    CorrenteMesResponseDto findCorrenteMaxMinMesAtual(@Param("codigoPublico") String codigoPublico);

}
