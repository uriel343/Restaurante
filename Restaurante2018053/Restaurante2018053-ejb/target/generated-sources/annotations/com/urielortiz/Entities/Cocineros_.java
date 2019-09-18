package com.urielortiz.Entities;

import com.urielortiz.Entities.Detalleorden;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T07:29:27")
@StaticMetamodel(Cocineros.class)
public class Cocineros_ { 

    public static volatile SingularAttribute<Cocineros, String> apellidos;
    public static volatile ListAttribute<Cocineros, Detalleorden> detalleordenList;
    public static volatile SingularAttribute<Cocineros, Integer> idcocinero;
    public static volatile SingularAttribute<Cocineros, Integer> edad;
    public static volatile SingularAttribute<Cocineros, String> nombres;

}