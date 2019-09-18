/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urielortiz.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "detalleorden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleorden.findAll", query = "SELECT d FROM Detalleorden d")
    , @NamedQuery(name = "Detalleorden.findByIdorden", query = "SELECT d FROM Detalleorden d WHERE d.detalleordenPK.idorden = :idorden")
    , @NamedQuery(name = "Detalleorden.findByIddetalleorden", query = "SELECT d FROM Detalleorden d WHERE d.detalleordenPK.iddetalleorden = :iddetalleorden")
    , @NamedQuery(name = "Detalleorden.findByPrecioplato", query = "SELECT d FROM Detalleorden d WHERE d.precioplato = :precioplato")
    , @NamedQuery(name = "Detalleorden.findByCantidadplato", query = "SELECT d FROM Detalleorden d WHERE d.cantidadplato = :cantidadplato")
    , @NamedQuery(name = "Detalleorden.findByPreciototal", query = "SELECT d FROM Detalleorden d WHERE d.preciototal = :preciototal")
    , @NamedQuery(name = "Detalleorden.findByFechaorden", query = "SELECT d FROM Detalleorden d WHERE d.fechaorden = :fechaorden")})
public class Detalleorden implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleordenPK detalleordenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioplato")
    private double precioplato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadplato")
    private int cantidadplato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciototal")
    private double preciototal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaorden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaorden;
    @JoinColumn(name = "idorden", referencedColumnName = "idorden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orden orden;
    @JoinColumn(name = "idcocinero", referencedColumnName = "idcocinero")
    @ManyToOne(optional = false)
    private Cocineros idcocinero;
    @JoinColumn(name = "idplato", referencedColumnName = "idplato")
    @ManyToOne(optional = false)
    private Platos idplato;

    public Detalleorden() {
    }

    public Detalleorden(DetalleordenPK detalleordenPK) {
        this.detalleordenPK = detalleordenPK;
    }

    public Detalleorden(DetalleordenPK detalleordenPK, double precioplato, int cantidadplato, double preciototal, Date fechaorden) {
        this.detalleordenPK = detalleordenPK;
        this.precioplato = precioplato;
        this.cantidadplato = cantidadplato;
        this.preciototal = preciototal;
        this.fechaorden = fechaorden;
    }

    public Detalleorden(int idorden, int iddetalleorden) {
        this.detalleordenPK = new DetalleordenPK(idorden, iddetalleorden);
    }

    public DetalleordenPK getDetalleordenPK() {
        return detalleordenPK;
    }

    public void setDetalleordenPK(DetalleordenPK detalleordenPK) {
        this.detalleordenPK = detalleordenPK;
    }

    public double getPrecioplato() {
        return precioplato;
    }

    public void setPrecioplato(double precioplato) {
        this.precioplato = precioplato;
    }

    public int getCantidadplato() {
        return cantidadplato;
    }

    public void setCantidadplato(int cantidadplato) {
        this.cantidadplato = cantidadplato;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Cocineros getIdcocinero() {
        return idcocinero;
    }

    public void setIdcocinero(Cocineros idcocinero) {
        this.idcocinero = idcocinero;
    }

    public Platos getIdplato() {
        return idplato;
    }

    public void setIdplato(Platos idplato) {
        this.idplato = idplato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleordenPK != null ? detalleordenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleorden)) {
            return false;
        }
        Detalleorden other = (Detalleorden) object;
        if ((this.detalleordenPK == null && other.detalleordenPK != null) || (this.detalleordenPK != null && !this.detalleordenPK.equals(other.detalleordenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urielortiz.Entities.Detalleorden[ detalleordenPK=" + detalleordenPK + " ]";
    }
    
}
