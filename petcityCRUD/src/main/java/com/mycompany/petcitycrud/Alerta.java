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
@Table(name = "alerta")
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findById", query = "SELECT a FROM Alerta a WHERE a.id = :id"),
    @NamedQuery(name = "Alerta.findByDescricao", query = "SELECT a FROM Alerta a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Alerta.findByDataInclusao", query = "SELECT a FROM Alerta a WHERE a.dataInclusao = :dataInclusao")})
public class Alerta implements Serializable {

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
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tipoocorrencia_id", referencedColumnName = "id")
    @ManyToOne
    private Tipoocorrencia tipoocorrenciaId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaId")
    private Collection<Localizacaoalerta> localizacaoalertaCollection;

    public Alerta() {
    }

    public Alerta(Integer id) {
        this.id = id;
    }

    public Alerta(Integer id, Date dataInclusao) {
        this.id = id;
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

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Tipoocorrencia getTipoocorrenciaId() {
        return tipoocorrenciaId;
    }

    public void setTipoocorrenciaId(Tipoocorrencia tipoocorrenciaId) {
        this.tipoocorrenciaId = tipoocorrenciaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Collection<Localizacaoalerta> getLocalizacaoalertaCollection() {
        return localizacaoalertaCollection;
    }

    public void setLocalizacaoalertaCollection(Collection<Localizacaoalerta> localizacaoalertaCollection) {
        this.localizacaoalertaCollection = localizacaoalertaCollection;
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
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Alerta[ id=" + id + " ]";
    }
    
}
