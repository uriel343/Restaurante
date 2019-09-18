/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urielortiz.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author programacion
 */
@Embeddable
public class DetalleordenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private int idorden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalleorden")
    private int iddetalleorden;

    public DetalleordenPK() {
    }

    public DetalleordenPK(int idorden, int iddetalleorden) {
        this.idorden = idorden;
        this.iddetalleorden = iddetalleorden;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public int getIddetalleorden() {
        return iddetalleorden;
    }

    public void setIddetalleorden(int iddetalleorden) {
        this.iddetalleorden = iddetalleorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idorden;
        hash += (int) iddetalleorden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleordenPK)) {
            return false;
        }
        DetalleordenPK other = (DetalleordenPK) object;
        if (this.idorden != other.idorden) {
            return false;
        }
        if (this.iddetalleorden != other.iddetalleorden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urielortiz.Entities.DetalleordenPK[ idorden=" + idorden + ", iddetalleorden=" + iddetalleorden + " ]";
    }
    
}
