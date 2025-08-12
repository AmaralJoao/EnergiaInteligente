package com.br.EnergiaInteligente.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "dispositivo")
public class DispositivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdDispositivo")
    private long id;

    @Column(name = "idDispositivo")
    private long identificadorDispositivo;

    @Column(name = "nmDispositivo")
    private String nomeDoDispositivo;

    @Column(name = "nmModeloDispositivo")
    private String modeloDispositivo;

    @Column(name = "nrVersaoDispositivo")
    private long versaoDoDispositivo;

    @ManyToOne
    @JoinColumn(name = "cdUsuario")
    private UsuarioModel usuario;


    public DispositivoModel() {
    }

    public DispositivoModel(long id, long identificadorDispositivo, String nomeDoDispositivo, String modeloDispositivo, long versaoDoDispositivo) {
        this.id = id;
        this.identificadorDispositivo = identificadorDispositivo;
        this.nomeDoDispositivo = nomeDoDispositivo;
        this.modeloDispositivo = modeloDispositivo;
        this.versaoDoDispositivo = versaoDoDispositivo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdentificadorDispositivo() {
        return identificadorDispositivo;
    }

    public void setIdentificadorDispositivo(long identificadorDispositivo) {
        this.identificadorDispositivo = identificadorDispositivo;
    }

    public String getNomeDoDispositivo() {
        return nomeDoDispositivo;
    }

    public void setNomeDoDispositivo(String nomeDoDispositivo) {
        this.nomeDoDispositivo = nomeDoDispositivo;
    }

    public String getModeloDispositivo() {
        return modeloDispositivo;
    }

    public void setModeloDispositivo(String modeloDispositivo) {
        this.modeloDispositivo = modeloDispositivo;
    }

    public long getVersaoDoDispositivo() {
        return versaoDoDispositivo;
    }

    public void setVersaoDoDispositivo(long versaoDoDispositivo) {
        this.versaoDoDispositivo = versaoDoDispositivo;
    }
}
