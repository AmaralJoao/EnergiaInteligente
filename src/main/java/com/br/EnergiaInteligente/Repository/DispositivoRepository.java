package com.br.EnergiaInteligente.Repository;

import com.br.EnergiaInteligente.Model.DispositivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoModel, Long> {

    DispositivoModel findByIdentificadorDispositivo(long identificadorPedido);


    DispositivoModel findByChipId(Long chipId);
}
