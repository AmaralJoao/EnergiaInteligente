package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);


    Optional<Long> findByTokenAtivo(String token);
}
