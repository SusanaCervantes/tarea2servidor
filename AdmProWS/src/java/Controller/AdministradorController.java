/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.AdministradorDto;
import service.AdministradorService;
import util.Respuesta;


/**
 *
 * @author Susana
 */
@WebService(serviceName = "AdministradorController")
public class AdministradorController {

    @EJB 
    AdministradorService administradorService;
    
    @WebMethod(operationName = "guardarAdministrador")
    public AdministradorDto guardarAdministrador(@WebParam(name = "administrador") AdministradorDto administrador) {
        return administradorService.guardarAdministrador(administrador);
        //respuesta.getResultado()
    }
    
    @WebMethod(operationName = "getAdministradores")
    public List<AdministradorDto> getAdministradores(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos) {
        return administradorService.getAdministradores(nombre, apellidos);
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public String eliminarAdministrador(@WebParam(name = "id") Long id){
        return administradorService.eliminarAdministrador(id);
    }
}
