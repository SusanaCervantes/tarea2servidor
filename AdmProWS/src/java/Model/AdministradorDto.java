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
@XmlRootElement (name = "AdministradorDto")
@XmlAccessorType (XmlAccessType.FIELD)
public class AdministradorDto {
    private Long id;
    private String nombre;
    private String apellidos; 
    private String usuario; 
    private String contrasena;
    private String cedula; 
    private String correo; 
    private String estado;
    private Long version;

    public AdministradorDto(Long id, String nombre, String apellidos, String usuario, String contrasena, String cedula, String correo, String estado, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = usuario;
        this.cedula = cedula;
        this.correo = correo;
        this.estado = estado;
        this.version = version;
    }
    
    public AdministradorDto(){
    
    }
    
    public AdministradorDto(Administrador adm){
        this.id = adm.getAdmId();
        this.nombre = adm.getAdmNombre();
        this.apellidos = adm.getAdmApellidos();
        this.usuario = adm.getAdmUsuario();
        this.contrasena = adm.getAdmContrasena();
        this.cedula = adm.getAdmCedula();
        this.correo = adm.getAdmCorreo();
        this.estado = adm.getAdmEstado();
        this.version = adm.getAdmVersion();
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
