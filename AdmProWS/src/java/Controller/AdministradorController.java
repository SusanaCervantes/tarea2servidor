/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdministradorDto;
import Service.AdministradorService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Susana
 */
@WebService(serviceName = "AdministradorController")
@Stateless()
public class AdministradorController {

    /**
     * This is a sample web service operation
     */
    @EJB 
    AdministradorService administradorService;
    
    @WebMethod(operationName = "guardarAdministrador")
    public String guardarAdministrador(@WebParam(name = "administrador") AdministradorDto admnistrador) {
        return administradorService.guardarAdministrador(admnistrador);
    }
    
    @WebMethod(operationName = "getAdministradores")
    public List<AdministradorDto> getAdministradores(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos) {
        return administradorService.getAdministradores(nombre, apellidos);
    }
}
