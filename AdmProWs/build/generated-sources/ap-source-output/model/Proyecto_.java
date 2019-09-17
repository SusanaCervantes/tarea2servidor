package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Actividad;
import model.Seguimiento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-16T21:54:24")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> proEstado;
    public static volatile SingularAttribute<Proyecto, BigInteger> proVersion;
    public static volatile SingularAttribute<Proyecto, String> proLtecnico;
    public static volatile ListAttribute<Proyecto, Actividad> actividadList;
    public static volatile SingularAttribute<Proyecto, String> proFpFinal;
    public static volatile SingularAttribute<Proyecto, String> proNombre;
    public static volatile SingularAttribute<Proyecto, String> proFrInicio;
    public static volatile SingularAttribute<Proyecto, String> proPatrocinador;
    public static volatile SingularAttribute<Proyecto, String> proFpInicio;
    public static volatile SingularAttribute<Proyecto, String> proLusuario;
    public static volatile ListAttribute<Proyecto, Seguimiento> seguimientoList;
    public static volatile SingularAttribute<Proyecto, BigDecimal> proId;
    public static volatile SingularAttribute<Proyecto, String> proFrFinal;

}