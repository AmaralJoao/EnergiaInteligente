package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, String> {

    @Query("SELECT t.usuario.id FROM TokenModel t WHERE t.token = :token AND t.ativa = true AND t.expiraEm > CURRENT_TIMESTAMP")
    Optional<SessaoModel> findCdUsuarioByTokenAtivo(String token);
}
