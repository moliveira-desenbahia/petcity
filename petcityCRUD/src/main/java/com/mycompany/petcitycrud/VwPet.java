/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcitycrud;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author m_jun
 */
@Entity
@Table(name = "vw_pet")
@NamedQueries({
    @NamedQuery(name = "VwPet.findAll", query = "SELECT v FROM VwPet v"),
    @NamedQuery(name = "VwPet.findByPetId", query = "SELECT v FROM VwPet v WHERE v.petId = :petId"),
    @NamedQuery(name = "VwPet.findByPetNome", query = "SELECT v FROM VwPet v WHERE v.petNome = :petNome"),
    @NamedQuery(name = "VwPet.findByPetSituacao", query = "SELECT v FROM VwPet v WHERE v.petSituacao = :petSituacao"),
    @NamedQuery(name = "VwPet.findByRacaNome", query = "SELECT v FROM VwPet v WHERE v.racaNome = :racaNome"),
    @NamedQuery(name = "VwPet.findByEspecieNome", query = "SELECT v FROM VwPet v WHERE v.especieNome = :especieNome"),
    @NamedQuery(name = "VwPet.findByPelagemNome", query = "SELECT v FROM VwPet v WHERE v.pelagemNome = :pelagemNome"),
    @NamedQuery(name = "VwPet.findByPetPorte", query = "SELECT v FROM VwPet v WHERE v.petPorte = :petPorte"),
    @NamedQuery(name = "VwPet.findByResponsavelNome", query = "SELECT v FROM VwPet v WHERE v.responsavelNome = :responsavelNome")})
public class VwPet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pet_id")
    private int petId;
    @Size(max = 255)
    @Column(name = "pet_nome")
    private String petNome;
    @Size(max = 2)
    @Column(name = "pet_situacao")
    private String petSituacao;
    @Size(max = 255)
    @Column(name = "raca_nome")
    private String racaNome;
    @Size(max = 255)
    @Column(name = "especie_nome")
    private String especieNome;
    @Size(max = 255)
    @Column(name = "pelagem_nome")
    private String pelagemNome;
    @Size(max = 255)
    @Column(name = "pet_porte")
    private String petPorte;
    @Size(max = 100)
    @Column(name = "responsavel_nome")
    private String responsavelNome;

    public VwPet() {
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetNome() {
        return petNome;
    }

    public void setPetNome(String petNome) {
        this.petNome = petNome;
    }

    public String getPetSituacao() {
        return petSituacao;
    }

    public void setPetSituacao(String petSituacao) {
        this.petSituacao = petSituacao;
    }

    public String getRacaNome() {
        return racaNome;
    }

    public void setRacaNome(String racaNome) {
        this.racaNome = racaNome;
    }

    public String getEspecieNome() {
        return especieNome;
    }

    public void setEspecieNome(String especieNome) {
        this.especieNome = especieNome;
    }

    public String getPelagemNome() {
        return pelagemNome;
    }

    public void setPelagemNome(String pelagemNome) {
        this.pelagemNome = pelagemNome;
    }

    public String getPetPorte() {
        return petPorte;
    }

    public void setPetPorte(String petPorte) {
        this.petPorte = petPorte;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public void setResponsavelNome(String responsavelNome) {
        this.responsavelNome = responsavelNome;
    }
    
}
