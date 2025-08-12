package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.MedicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicaoRepository extends JpaRepository<MedicaoModel, Long> {
}
