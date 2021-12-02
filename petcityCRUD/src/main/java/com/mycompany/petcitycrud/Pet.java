/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcitycrud;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author m_jun
 */
@Entity
@Table(name = "pet")
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findById", query = "SELECT p FROM Pet p WHERE p.id = :id"),
    @NamedQuery(name = "Pet.findByNome", query = "SELECT p FROM Pet p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pet.findBySituacao", query = "SELECT p FROM Pet p WHERE p.situacao = :situacao"),
    @NamedQuery(name = "Pet.findByDisponivelAdocao", query = "SELECT p FROM Pet p WHERE p.disponivelAdocao = :disponivelAdocao"),
    @NamedQuery(name = "Pet.findByDataInclusao", query = "SELECT p FROM Pet p WHERE p.dataInclusao = :dataInclusao")})
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponivel_adocao")
    private boolean disponivelAdocao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petId")
    private Collection<CaracteristicasAdicionais> caracteristicasAdicionaisCollection;
    @OneToMany(mappedBy = "petId")
    private Collection<Ocorrencia> ocorrenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petId")
    private Collection<Localizacaopet> localizacaopetCollection;
    @JoinColumn(name = "pelagem_id", referencedColumnName = "id")
    @ManyToOne
    private Pelagem pelagemId;
    @JoinColumn(name = "pessoaresponsavel_id", referencedColumnName = "id")
    @ManyToOne
    private Pessoa pessoaresponsavelId;
    @JoinColumn(name = "porte_id", referencedColumnName = "id")
    @ManyToOne
    private Porte porteId;
    @JoinColumn(name = "raca_id", referencedColumnName = "id")
    @ManyToOne
    private Raca racaId;

    public Pet() {
    }

    public Pet(Integer id) {
        this.id = id;
    }

    public Pet(Integer id, boolean disponivelAdocao, Date dataInclusao) {
        this.id = id;
        this.disponivelAdocao = disponivelAdocao;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public boolean getDisponivelAdocao() {
        return disponivelAdocao;
    }

    public void setDisponivelAdocao(boolean disponivelAdocao) {
        this.disponivelAdocao = disponivelAdocao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Collection<CaracteristicasAdicionais> getCaracteristicasAdicionaisCollection() {
        return caracteristicasAdicionaisCollection;
    }

    public void setCaracteristicasAdicionaisCollection(Collection<CaracteristicasAdicionais> caracteristicasAdicionaisCollection) {
        this.caracteristicasAdicionaisCollection = caracteristicasAdicionaisCollection;
    }

    public Collection<Ocorrencia> getOcorrenciaCollection() {
        return ocorrenciaCollection;
    }

    public void setOcorrenciaCollection(Collection<Ocorrencia> ocorrenciaCollection) {
        this.ocorrenciaCollection = ocorrenciaCollection;
    }

    public Collection<Localizacaopet> getLocalizacaopetCollection() {
        return localizacaopetCollection;
    }

    public void setLocalizacaopetCollection(Collection<Localizacaopet> localizacaopetCollection) {
        this.localizacaopetCollection = localizacaopetCollection;
    }

    public Pelagem getPelagemId() {
        return pelagemId;
    }

    public void setPelagemId(Pelagem pelagemId) {
        this.pelagemId = pelagemId;
    }

    public Pessoa getPessoaresponsavelId() {
        return pessoaresponsavelId;
    }

    public void setPessoaresponsavelId(Pessoa pessoaresponsavelId) {
        this.pessoaresponsavelId = pessoaresponsavelId;
    }

    public Porte getPorteId() {
        return porteId;
    }

    public void setPorteId(Porte porteId) {
        this.porteId = porteId;
    }

    public Raca getRacaId() {
        return racaId;
    }

    public void setRacaId(Raca racaId) {
        this.racaId = racaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Pet[ id=" + id + " ]";
    }
    
}
