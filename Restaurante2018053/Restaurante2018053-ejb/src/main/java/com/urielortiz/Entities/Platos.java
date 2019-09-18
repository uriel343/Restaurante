/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urielortiz.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "platos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platos.findAll", query = "SELECT p FROM Platos p")
    , @NamedQuery(name = "Platos.findByIdplato", query = "SELECT p FROM Platos p WHERE p.idplato = :idplato")
    , @NamedQuery(name = "Platos.findByNombreplato", query = "SELECT p FROM Platos p WHERE p.nombreplato = :nombreplato")
    , @NamedQuery(name = "Platos.findByPrecioplato", query = "SELECT p FROM Platos p WHERE p.precioplato = :precioplato")})
public class Platos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idplato")
    private Integer idplato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreplato")
    private String nombreplato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioplato")
    private double precioplato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplato")
    private List<Detalleorden> detalleordenList;

    public Platos() {
    }

    public Platos(Integer idplato) {
        this.idplato = idplato;
    }

    public Platos(Integer idplato, String nombreplato, double precioplato) {
        this.idplato = idplato;
        this.nombreplato = nombreplato;
        this.precioplato = precioplato;
    }

    public Integer getIdplato() {
        return idplato;
    }

    public void setIdplato(Integer idplato) {
        this.idplato = idplato;
    }

    public String getNombreplato() {
        return nombreplato;
    }

    public void setNombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }

    public double getPrecioplato() {
        return precioplato;
    }

    public void setPrecioplato(double precioplato) {
        this.precioplato = precioplato;
    }

    @XmlTransient
    public List<Detalleorden> getDetalleordenList() {
        return detalleordenList;
    }

    public void setDetalleordenList(List<Detalleorden> detalleordenList) {
        this.detalleordenList = detalleordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplato != null ? idplato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platos)) {
            return false;
        }
        Platos other = (Platos) object;
        if ((this.idplato == null && other.idplato != null) || (this.idplato != null && !this.idplato.equals(other.idplato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urielortiz.Entities.Platos[ idplato=" + idplato + " ]";
    }
    
}
