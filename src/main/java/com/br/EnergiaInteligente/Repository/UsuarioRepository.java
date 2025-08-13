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

    /*@Query("SELECT u FROM UsuarioModel u WHERE u.token = :token AND u.ativo = true")
    Optional<Long> findByToken(@Param(("token")) String token);*/
}
