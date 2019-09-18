package com.urielortiz.Entities;

import com.urielortiz.Entities.Cocineros;
import com.urielortiz.Entities.DetalleordenPK;
import com.urielortiz.Entities.Orden;
import com.urielortiz.Entities.Platos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T07:29:27")
@StaticMetamodel(Detalleorden.class)
public class Detalleorden_ { 

    public static volatile SingularAttribute<Detalleorden, Double> precioplato;
    public static volatile SingularAttribute<Detalleorden, Integer> cantidadplato;
    public static volatile SingularAttribute<Detalleorden, DetalleordenPK> detalleordenPK;
    public static volatile SingularAttribute<Detalleorden, Platos> idplato;
    public static volatile SingularAttribute<Detalleorden, Double> preciototal;
    public static volatile SingularAttribute<Detalleorden, Date> fechaorden;
    public static volatile SingularAttribute<Detalleorden, Orden> orden;
    public static volatile SingularAttribute<Detalleorden, Cocineros> idcocinero;

}