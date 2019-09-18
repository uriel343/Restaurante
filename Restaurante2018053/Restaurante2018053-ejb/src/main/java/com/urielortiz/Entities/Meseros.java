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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meseros.findAll", query = "SELECT m FROM Meseros m")
    , @NamedQuery(name = "Meseros.findByIdmesero", query = "SELECT m FROM Meseros m WHERE m.idmesero = :idmesero")
    , @NamedQuery(name = "Meseros.findByNombres", query = "SELECT m FROM Meseros m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Meseros.findByApellidos", query = "SELECT m FROM Meseros m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Meseros.findByEdad", query = "SELECT m FROM Meseros m WHERE m.edad = :edad")})
public class Meseros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmesero")
    private Integer idmesero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmesero")
    private List<Orden> ordenList;

    public Meseros() {
    }

    public Meseros(Integer idmesero) {
        this.idmesero = idmesero;
    }

    public Meseros(Integer idmesero, String nombres, String apellidos, int edad) {
        this.idmesero = idmesero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Integer getIdmesero() {
        return idmesero;
    }

    public void setIdmesero(Integer idmesero) {
        this.idmesero = idmesero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmesero != null ? idmesero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meseros)) {
            return false;
        }
        Meseros other = (Meseros) object;
        if ((this.idmesero == null && other.idmesero != null) || (this.idmesero != null && !this.idmesero.equals(other.idmesero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urielortiz.Entities.Meseros[ idmesero=" + idmesero + " ]";
    }
    
}
