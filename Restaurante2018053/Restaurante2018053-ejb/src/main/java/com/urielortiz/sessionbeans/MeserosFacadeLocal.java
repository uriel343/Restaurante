/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urielortiz.sessionbeans;

import com.urielortiz.Entities.Meseros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface MeserosFacadeLocal {

    void create(Meseros meseros);

    void edit(Meseros meseros);

    void remove(Meseros meseros);

    Meseros find(Object id);

    List<Meseros> findAll();

    List<Meseros> findRange(int[] range);

    int count();
    
}
