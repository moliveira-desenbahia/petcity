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
@Table(name = "localizacaoalerta")
@NamedQueries({
    @NamedQuery(name = "Localizacaoalerta.findAll", query = "SELECT l FROM Localizacaoalerta l"),
    @NamedQuery(name = "Localizacaoalerta.findById", query = "SELECT l FROM Localizacaoalerta l WHERE l.id = :id"),
    @NamedQuery(name = "Localizacaoalerta.findByLatitude", query = "SELECT l FROM Localizacaoalerta l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Localizacaoalerta.findByLongitude", query = "SELECT l FROM Localizacaoalerta l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "Localizacaoalerta.findByDataInclusao", query = "SELECT l FROM Localizacaoalerta l WHERE l.dataInclusao = :dataInclusao")})
public class Localizacaoalerta implements Serializable {

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
    @JoinColumn(name = "alerta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alerta alertaId;

    public Localizacaoalerta() {
    }

    public Localizacaoalerta(Integer id) {
        this.id = id;
    }

    public Localizacaoalerta(Integer id, long latitude, long longitude, Date dataInclusao) {
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

    public Alerta getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(Alerta alertaId) {
        this.alertaId = alertaId;
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
        if (!(object instanceof Localizacaoalerta)) {
            return false;
        }
        Localizacaoalerta other = (Localizacaoalerta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Localizacaoalerta[ id=" + id + " ]";
    }
    
}
