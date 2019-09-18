package com.urielortiz.Entities;

import com.urielortiz.Entities.Clientes;
import com.urielortiz.Entities.Detalleorden;
import com.urielortiz.Entities.Mesas;
import com.urielortiz.Entities.Meseros;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T07:29:27")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Mesas> idmesa;
    public static volatile ListAttribute<Orden, Detalleorden> detalleordenList;
    public static volatile SingularAttribute<Orden, Integer> idorden;
    public static volatile SingularAttribute<Orden, Meseros> idmesero;
    public static volatile SingularAttribute<Orden, Clientes> idcliente;

}