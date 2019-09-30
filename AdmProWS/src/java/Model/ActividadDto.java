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
 * @author Pablo-VE
 */

@XmlRootElement (name = "ActividadDto")
@XmlAccessorType (XmlAccessType.FIELD)
    
public class ActividadDto {
    private Long id;
    private String nombre;
    private String encargado; 
    private String fpinicio; 
    private String fpfinal;
    private String frinicio; 
    private String frfinal; 
    private String descripcion;
    private String estado;
    private Long orden;
    private Long version;
    private ProyectosDto pro;

    public ActividadDto(Long id, String nombre, String encargado, String fpinicio, String fpfinal, String frinicio, String frfinal, String descripcion, String estado, Long orden, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.fpinicio = fpinicio;
        this.fpfinal = fpfinal;
        this.frinicio = frinicio;
        this.frfinal = frfinal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.orden = orden;
        this.version = version;
        //proyecto
    }

    public ActividadDto() {
    }
    
   public ActividadDto(Actividad act) {
        this.id = act.getActId();
        this.nombre = act.getActNombre();
        this.encargado = act.getActEncargado();
        this.fpinicio = act.getActFpInicio();
        this.fpfinal = act.getActFpFinal();
        this.frinicio = act.getActFrInicio();
        this.frfinal = act.getActFrFinal();
        this.descripcion = act.getActDescripcion();
        this.estado = act.getActEstado();
        this.orden = act.getActOrden();
        this.version = act.getActVersion();
        if(act.getProId() != null)
            pro = new ProyectosDto(act.getProId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getFpinicio() {
        return fpinicio;
    }

    public void setFpinicio(String fpinicio) {
        this.fpinicio = fpinicio;
    }

    public String getFpfinal() {
        return fpfinal;
    }

    public void setFpfinal(String fpfinal) {
        this.fpfinal = fpfinal;
    }

    public String getFrinicio() {
        return frinicio;
    }

    public void setFrinicio(String frinicio) {
        this.frinicio = frinicio;
    }

    public String getFrfinal() {
        return frfinal;
    }

    public void setFrfinal(String frfinal) {
        this.frfinal = frfinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ProyectosDto getPro() {
        return pro;
    }
    
    
    
}
    

