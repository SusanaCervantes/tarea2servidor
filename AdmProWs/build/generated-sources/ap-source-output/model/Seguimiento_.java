package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-16T21:54:24")
@StaticMetamodel(Seguimiento.class)
public class Seguimiento_ { 

    public static volatile SingularAttribute<Seguimiento, String> segFecha;
    public static volatile SingularAttribute<Seguimiento, BigDecimal> segId;
    public static volatile SingularAttribute<Seguimiento, BigInteger> segPorcentaje;
    public static volatile SingularAttribute<Seguimiento, BigInteger> segVersion;
    public static volatile SingularAttribute<Seguimiento, Proyecto> proId;
    public static volatile SingularAttribute<Seguimiento, String> segDetalle;

}