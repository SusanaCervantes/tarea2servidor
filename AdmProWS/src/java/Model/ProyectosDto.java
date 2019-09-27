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
    private AdministradorDto admId;
    private String proCorreoLtecnico;
    private String proCorreoPatrocinador;
    private String proNombre;
    private List<SeguimientoDto> seguimientosList;
    private List<ActividadDto> actividadList;

    public ProyectosDto(){
        this.seguimientosList = new ArrayList();
    }


    public String getProCorreoLtecnico() {
        return proCorreoLtecnico;
    }

    public void setProCorreoLtecnico(String proCorreoLtecnico) {
        this.proCorreoLtecnico = proCorreoLtecnico;
    }

    public String getProCorreoPatrocinador() {
        return proCorreoPatrocinador;
    }

    public void setProCorreoPatrocinador(String proCorreoPatrocinador) {
        this.proCorreoPatrocinador = proCorreoPatrocinador;
    }

    public List<ActividadDto> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        for(Actividad act: actividadList){
            this.actividadList.add(new ActividadDto(act));
        }
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
        this.admId = new AdministradorDto(proyecto.getAdmId());
        this.proNombre = proyecto.getProNombre();
        setSeguimientosList(proyecto.getSeguimientoList());
        this.proCorreoLtecnico = proyecto.getProCorreoLtecnico();
        this.proCorreoPatrocinador = proyecto.getProCorreoPatrocinador();
        setActividadList(proyecto.getActividadList());
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

    public AdministradorDto getAdmId() {
        return admId;
    }

    public void setAdmId(Administrador admId) {
        this.admId = new AdministradorDto(admId);
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public List<SeguimientoDto> getSeguimientosList() {
        return seguimientosList;
    }

    public void setSeguimientosList(List<Seguimiento> seguimientosList) {
        for(Seguimiento seg: seguimientosList){
            this.seguimientosList.add(new SeguimientoDto(seg));
        }
    } 
    
    public List<Seguimiento>  getListSeg(){
        List<Seguimiento> list = new ArrayList();
        for(SeguimientoDto seg: seguimientosList){
            list.add(new Seguimiento(seg));
        }
        return list;
    }
    
    public List<Actividad> getListAct(){
        List<Actividad> list = new ArrayList();
        for(ActividadDto act: actividadList){
            list.add(new Actividad(act));
        }
        return list;
    }
}
