package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.SessaoModel;
import com.br.EnergiaInteligente.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, String> {

}
