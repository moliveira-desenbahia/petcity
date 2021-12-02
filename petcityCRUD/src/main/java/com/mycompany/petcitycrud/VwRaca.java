/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcitycrud;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author m_jun
 */
@Entity
@Table(name = "vw_raca")
@NamedQueries({
    @NamedQuery(name = "VwRaca.findAll", query = "SELECT v FROM VwRaca v"),
    @NamedQuery(name = "VwRaca.findByRacaNome", query = "SELECT v FROM VwRaca v WHERE v.racaNome = :racaNome"),
    @NamedQuery(name = "VwRaca.findByEspecieNome", query = "SELECT v FROM VwRaca v WHERE v.especieNome = :especieNome")})
public class VwRaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "raca_nome")
    private String racaNome;
    @Size(max = 255)
    @Column(name = "especie_nome")
    private String especieNome;

    public VwRaca() {
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
    
}
