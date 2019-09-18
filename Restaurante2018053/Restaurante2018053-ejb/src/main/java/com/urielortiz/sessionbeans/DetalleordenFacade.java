/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urielortiz.sessionbeans;

import com.urielortiz.Entities.Detalleorden;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class DetalleordenFacade extends AbstractFacade<Detalleorden> implements DetalleordenFacadeLocal {

    @PersistenceContext(unitName = "Restaurante2018053PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleordenFacade() {
        super(Detalleorden.class);
    }
    
}
