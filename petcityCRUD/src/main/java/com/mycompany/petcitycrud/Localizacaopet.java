/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcitycrud;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "localizacaopet")
@NamedQueries({
    @NamedQuery(name = "Localizacaopet.findAll", query = "SELECT l FROM Localizacaopet l"),
    @NamedQuery(name = "Localizacaopet.findById", query = "SELECT l FROM Localizacaopet l WHERE l.id = :id"),
    @NamedQuery(name = "Localizacaopet.findByLatitude", query = "SELECT l FROM Localizacaopet l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Localizacaopet.findByLongitude", query = "SELECT l FROM Localizacaopet l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "Localizacaopet.findByDataInclusao", query = "SELECT l FROM Localizacaopet l WHERE l.dataInclusao = :dataInclusao")})
public class Localizacaopet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private long latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private long longitude;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pet petId;

    public Localizacaopet() {
    }

    public Localizacaopet(Integer id) {
        this.id = id;
    }

    public Localizacaopet(Integer id, long latitude, long longitude, Date dataInclusao) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
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
        if (!(object instanceof Localizacaopet)) {
            return false;
        }
        Localizacaopet other = (Localizacaopet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Localizacaopet[ id=" + id + " ]";
    }
    
}
