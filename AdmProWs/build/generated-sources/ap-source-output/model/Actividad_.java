package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-16T21:54:24")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> actDescripcion;
    public static volatile SingularAttribute<Actividad, String> actFrFinal;
    public static volatile SingularAttribute<Actividad, BigInteger> actOrden;
    public static volatile SingularAttribute<Actividad, String> actNombre;
    public static volatile SingularAttribute<Actividad, String> actEstado;
    public static volatile SingularAttribute<Actividad, BigInteger> actVersion;
    public static volatile SingularAttribute<Actividad, Proyecto> proId;
    public static volatile SingularAttribute<Actividad, BigDecimal> actId;
    public static volatile SingularAttribute<Actividad, String> actFrInicio;
    public static volatile SingularAttribute<Actividad, String> actFpFinal;
    public static volatile SingularAttribute<Actividad, String> actEncargado;
    public static volatile SingularAttribute<Actividad, String> actFpInicio;

}