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
@Table(name = "contatos")
@NamedQueries({
    @NamedQuery(name = "Contatos.findAll", query = "SELECT c FROM Contatos c"),
    @NamedQuery(name = "Contatos.findById", query = "SELECT c FROM Contatos c WHERE c.id = :id"),
    @NamedQuery(name = "Contatos.findByTipo", query = "SELECT c FROM Contatos c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Contatos.findByValor", query = "SELECT c FROM Contatos c WHERE c.valor = :valor"),
    @NamedQuery(name = "Contatos.findByPessoaId", query = "SELECT c FROM Contatos c WHERE c.pessoaId = :pessoaId"),
    @NamedQuery(name = "Contatos.findByDataInclusao", query = "SELECT c FROM Contatos c WHERE c.dataInclusao = :dataInclusao")})
public class Contatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "valor")
    private String valor;
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public Contatos() {
    }

    public Contatos(Integer id) {
        this.id = id;
    }

    public Contatos(Integer id, Date dataInclusao) {
        this.id = id;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
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
        if (!(object instanceof Contatos)) {
            return false;
        }
        Contatos other = (Contatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Contatos[ id=" + id + " ]";
    }
    
}
