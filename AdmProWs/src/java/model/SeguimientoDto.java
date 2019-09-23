/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Susana
 */
@XmlRootElement (name = "SeguimientoDto")
@XmlAccessorType (XmlAccessType.FIELD)
public class SeguimientoDto {
    private Long id;
    private String detalle;
    private String fecha;
    private String porcentaje;
    private Long version;
           
    public SeguimientoDto()
    {
    
    }
    
    public SeguimientoDto(Seguimiento seg)
    {
        this.id = seg.getSegId();
        this.detalle = seg.getSegDetalle();
        this.fecha = seg.getSegFecha();
        this.porcentaje = seg.getSegPorcentaje().toString();
        this.version = seg.getSegVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
