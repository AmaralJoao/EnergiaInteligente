package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoMedicao")
public class TipoMedicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descicao;

    public TipoMedicaoModel() {
    }

    public TipoMedicaoModel(Long id, String descicao) {
        this.id = id;
        this.descicao = descicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }
}
