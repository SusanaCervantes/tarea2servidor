/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivana
 */
@XmlRootElement (name = "ProyectosDto")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProyectosDto {
    
    private Long proId;
    private String proPatrocinador;
    private String proLtecnico;
    private String proFpInicio;
    private String proFpFinal;
    private String proFrInicio;
    private String proFrFinal;
    private String proEstado;
    private Administrador admId;
    
    private String proNombre;
    private List<Seguimiento> seguimientosList;

    public ProyectosDto(){
        this.seguimientosList = new ArrayList();
    }
    
    public ProyectosDto(Long proId, String proPatrocinador, String proLtecnico, String proFpInicio, String proFpFinal, String proFrInicio, String proFrFinal, String proEstado, model.Administrador admId, String proNombre, List<model.Seguimiento> seguimientosList) {
        this.proId = proId;
        this.proPatrocinador = proPatrocinador;
        this.proLtecnico = proLtecnico;
        this.proFpInicio = proFpInicio;
        this.proFpFinal = proFpFinal;
        this.proFrInicio = proFrInicio;
        this.proFrFinal = proFrFinal;
        this.proEstado = proEstado;
        this.admId = admId;
        this.proNombre = proNombre;
        this.seguimientosList = seguimientosList;
    }
    
    /**
     *
     * @param proyecto
     */
    public ProyectosDto(Proyecto proyecto){
        //this();
        this.proId = proyecto.getProId();
        this.proPatrocinador = proyecto.getProPatrocinador();
        this.proLtecnico = proyecto.getProLtecnico();
        this.proFpInicio = proyecto.getProFpInicio();
        this.proFpFinal = proyecto.getProFpFinal();
        this.proFrInicio = proyecto.getProFrInicio();
        this.proFrFinal = proyecto.getProFrFinal();
        this.proEstado = proyecto.getProEstado();
        this.admId = proyecto.getAdmId();
        this.proNombre = proyecto.getProNombre();
        this.seguimientosList = proyecto.getSeguimientoList();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProPatrocinador() {
        return proPatrocinador;
    }

    public void setProPatrocinador(String proPatrocinador) {
        this.proPatrocinador = proPatrocinador;
    }

    public String getProLtecnico() {
        return proLtecnico;
    }

    public void setProLtecnico(String proLtecnico) {
        this.proLtecnico = proLtecnico;
    }

    public String getProFpInicio() {
        return proFpInicio;
    }

    public void setProFpInicio(String proFpInicio) {
        this.proFpInicio = proFpInicio;
    }

    public String getProFpFinal() {
        return proFpFinal;
    }

    public void setProFpFinal(String proFpFinal) {
        this.proFpFinal = proFpFinal;
    }

    public String getProFrInicio() {
        return proFrInicio;
    }

    public void setProFrInicio(String proFrInicio) {
        this.proFrInicio = proFrInicio;
    }

    public String getProFrFinal() {
        return proFrFinal;
    }

    public void setProFrFinal(String proFrFinal) {
        this.proFrFinal = proFrFinal;
    }

    public String getProEstado() {
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
    }

    public model.Administrador getAdmId() {
        return admId;
    }

    public void setAdmId(model.Administrador admId) {
        this.admId = admId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public List<Seguimiento> getSeguimientosList() {
        return seguimientosList;
    }

    public void setSeguimientosList(List<model.Seguimiento> seguimientosList) {
        this.seguimientosList = seguimientosList;
    } 
}
