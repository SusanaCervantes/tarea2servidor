/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Susana
 */
@XmlRootElement (name = "AdministradorDto")
@XmlAccessorType (XmlAccessType.FIELD)
public class AdministradorDto {
    private Long id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos; 
    private SimpleStringProperty usuario; 
    private SimpleStringProperty contrasena;
    private SimpleStringProperty cedula; 
    private SimpleStringProperty correo; 
    private SimpleStringProperty estado;
    private Long version;

    public AdministradorDto(Long id, String nombre, String apellidos, String usuario, String contrasena, String cedula, String correo, String estado, Long version) {
        this.id = id;
        this.nombre.set(nombre);
        this.apellidos.set(apellidos);
        this.usuario.set(usuario);
        this.contrasena.set(usuario);
        this.cedula.set(cedula);
        this.correo.set(correo);
        this.estado.set(estado);
        this.version = version;
    }
    
    public AdministradorDto(){
    
    }
    
    public AdministradorDto(Administrador adm){
        this.id = adm.getAdmId();
        this.nombre.set(adm.getAdmNombre());
        this.apellidos.set(adm.getAdmApellidos());
        this.usuario.set(adm.getAdmUsuario());
        this.contrasena.set(adm.getAdmContrasena());
        this.cedula.set(adm.getAdmCedula());
        this.correo.set(adm.getAdmCorreo());
        this.estado.set(adm.getAdmEstado());
        this.version = adm.getAdmVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleStringProperty getNombre() {
        return nombre;
    }

    public void setNombre(SimpleStringProperty nombre) {
        this.nombre = nombre;
    }

    public SimpleStringProperty getApellidos() {
        return apellidos;
    }

    public void setApellidos(SimpleStringProperty apellidos) {
        this.apellidos = apellidos;
    }

    public SimpleStringProperty getUsuario() {
        return usuario;
    }

    public void setUsuario(SimpleStringProperty usuario) {
        this.usuario = usuario;
    }

    public SimpleStringProperty getContrasena() {
        return contrasena;
    }

    public void setContrasena(SimpleStringProperty contrasena) {
        this.contrasena = contrasena;
    }

    public SimpleStringProperty getCedula() {
        return cedula;
    }

    public void setCedula(SimpleStringProperty cedula) {
        this.cedula = cedula;
    }

    public SimpleStringProperty getCorreo() {
        return correo;
    }

    public void setCorreo(SimpleStringProperty correo) {
        this.correo = correo;
    }

    public SimpleStringProperty getEstado() {
        return estado;
    }

    public void setEstado(SimpleStringProperty estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
