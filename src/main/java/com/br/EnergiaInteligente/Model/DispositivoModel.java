package com.br.EnergiaInteligente.Model;

import com.br.EnergiaInteligente.Utils.GeradoIdentificadorUtil;
import jakarta.persistence.*;

@Entity
@Table(name = "dispositivo")
public class DispositivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdDispositivo")
    private long id;

    @Column(name = "cdPublico", unique = true, nullable = false, updatable = false, length = 20)
    private String codigoPublico;

    @Column(name = "macAddres")
    private String macAddres;

    @Column(name = "chipId")
    private long chipId;

    @Column(name = "idDispositivo")
    private long identificadorDispositivo;

    @Column(name = "nmDispositivo")
    private String nomeDoDispositivo;

    @Column(name = "nmModeloDispositivo")
    private String modeloDispositivo;

    @Column(name = "nrVersaoDispositivo")
    private long versaoDoDispositivo;

    @Column(name = "apiKey")
    private String apiKey;

    @ManyToOne
    @JoinColumn(name = "cdUsuario")
    private UsuarioModel usuario;


    public DispositivoModel() {
    }

    public DispositivoModel(long id, String macAddres, long chipId, long identificadorDispositivo, String nomeDoDispositivo, String modeloDispositivo, long versaoDoDispositivo, String apiKey, UsuarioModel usuario) {
        this.id = id;
        this.macAddres = macAddres;
        this.chipId = chipId;
        this.identificadorDispositivo = identificadorDispositivo;
        this.nomeDoDispositivo = nomeDoDispositivo;
        this.modeloDispositivo = modeloDispositivo;
        this.versaoDoDispositivo = versaoDoDispositivo;
        this.apiKey = apiKey;
        this.usuario = usuario;
    }

    @PrePersist
    public void prePersist() {
        if (this.codigoPublico == null) {
            this.codigoPublico = GeradoIdentificadorUtil.generateSecureId().toUpperCase();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMacAddres() {
        return macAddres;
    }

    public void setMacAddres(String macAddres) {
        this.macAddres = macAddres;
    }

    public long getChipId() {
        return chipId;
    }

    public void setChipId(long chipId) {
        this.chipId = chipId;
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCodigoPublico() {
        return codigoPublico;
    }

    public void setCodigoPublico(String codigoPublico) {
        this.codigoPublico = codigoPublico;
    }
}
