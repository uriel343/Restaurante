package com.urielortiz.Entities;

import com.urielortiz.Entities.Areas;
import com.urielortiz.Entities.Orden;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T07:29:27")
@StaticMetamodel(Mesas.class)
public class Mesas_ { 

    public static volatile SingularAttribute<Mesas, Integer> idmesa;
    public static volatile SingularAttribute<Mesas, Areas> idarea;
    public static volatile ListAttribute<Mesas, Orden> ordenList;
    public static volatile SingularAttribute<Mesas, String> capacidad;

}