package com.urielortiz.Entities;

import com.urielortiz.Entities.Orden;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T07:29:27")
@StaticMetamodel(Meseros.class)
public class Meseros_ { 

    public static volatile SingularAttribute<Meseros, String> apellidos;
    public static volatile ListAttribute<Meseros, Orden> ordenList;
    public static volatile SingularAttribute<Meseros, Integer> idmesero;
    public static volatile SingularAttribute<Meseros, Integer> edad;
    public static volatile SingularAttribute<Meseros, String> nombres;

}