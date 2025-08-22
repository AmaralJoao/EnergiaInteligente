package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);

    @Query("SELECT u FROM UsuarioModel u JOIN SessaoModel s on s.usuario.id = u.id WHERE s.token = :token AND s.ativa = true AND s.expiraEm > CURRENT_TIMESTAMP")
    Optional<UsuarioModel> findUsuarioByTokenAtivo(@Param("token") String token);

    Optional<UsuarioModel> findByCodigoPublico(String codigoPublico);

    boolean existsByCodigoPublico(String codigoPublico);
}
