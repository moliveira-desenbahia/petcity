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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByDataInclusao", query = "SELECT u FROM Usuario u WHERE u.dataInclusao = :dataInclusao")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Alerta> alertaCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<CaracteristicasAdicionais> caracteristicasAdicionaisCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Contatos> contatosCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Ocorrencia> ocorrenciaCollection;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String email, String senha, Date dataInclusao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Collection<Alerta> getAlertaCollection() {
        return alertaCollection;
    }

    public void setAlertaCollection(Collection<Alerta> alertaCollection) {
        this.alertaCollection = alertaCollection;
    }

    public Collection<CaracteristicasAdicionais> getCaracteristicasAdicionaisCollection() {
        return caracteristicasAdicionaisCollection;
    }

    public void setCaracteristicasAdicionaisCollection(Collection<CaracteristicasAdicionais> caracteristicasAdicionaisCollection) {
        this.caracteristicasAdicionaisCollection = caracteristicasAdicionaisCollection;
    }

    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Collection<Contatos> getContatosCollection() {
        return contatosCollection;
    }

    public void setContatosCollection(Collection<Contatos> contatosCollection) {
        this.contatosCollection = contatosCollection;
    }

    public Collection<Ocorrencia> getOcorrenciaCollection() {
        return ocorrenciaCollection;
    }

    public void setOcorrenciaCollection(Collection<Ocorrencia> ocorrenciaCollection) {
        this.ocorrenciaCollection = ocorrenciaCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.petcitycrud.Usuario[ id=" + id + " ]";
    }
    
}
