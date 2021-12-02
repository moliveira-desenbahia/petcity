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
@Table(name = "caracteristicas_adicionais")
@NamedQueries({
    @NamedQuery(name = "CaracteristicasAdicionais.findAll", query = "SELECT c FROM CaracteristicasAdicionais c"),
    @NamedQuery(name = "CaracteristicasAdicionais.findById", query = "SELECT c FROM CaracteristicasAdicionais c WHERE c.id = :id"),
    @NamedQuery(name = "CaracteristicasAdicionais.findByDescricao", query = "SELECT c FROM CaracteristicasAdicionais c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CaracteristicasAdicionais.findByConfirmada", query = "SELECT c FROM CaracteristicasAdicionais c WHERE c.confirmada = :confirmada"),
    @NamedQuery(name = "CaracteristicasAdicionais.findByDataInclusao", query = "SELECT c FROM CaracteristicasAdicionais c WHERE c.dataInclusao = :dataInclusao")})
public class CaracteristicasAdicionais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmada")
    private boolean confirmada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pet petId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public CaracteristicasAdicionais() {
    }

    public CaracteristicasAdicionais(Integer id) {
        this.id = id;
    }

    public CaracteristicasAdicionais(Integer id, boolean confirmada, Date dataInclusao) {
        this.id = id;
        this.confirmada = confirmada;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
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

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof CaracteristicasAdicionais)) {
            return false;
        }
        CaracteristicasAdicionais other = (CaracteristicasAdicionais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.CaracteristicasAdicionais[ id=" + id + " ]";
    }
    
}
