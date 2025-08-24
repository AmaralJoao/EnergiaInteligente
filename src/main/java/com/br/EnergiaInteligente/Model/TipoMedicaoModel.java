package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoMedicao")
public class TipoMedicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dsTipoMedicao")
    private String descricao;

    public TipoMedicaoModel() {
    }

    public TipoMedicaoModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descicao) {
        this.descricao = descicao;
    }
}
