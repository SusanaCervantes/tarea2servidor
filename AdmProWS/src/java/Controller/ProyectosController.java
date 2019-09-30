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
import model.ProyectosDto;
import service.ProyectosService;

/**
 *
 * @author Susana
 */
@WebService(serviceName = "ProyectosController")
public class ProyectosController {

    @EJB
    ProyectosService service;
    

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getProyectos")
    public List<ProyectosDto> getProyectos() {
        return service.getAll();
    }
    
    
    @WebMethod(operationName = "guardarProyectos")
    public ProyectosDto guardarProyectos(@WebParam(name = "proyecto") ProyectosDto proyecto) {
        return service.guardarProyecto(proyecto);
    }
    
    
    @WebMethod(operationName = "eliminarProyecto")
    public Integer eliminarProyecto(@WebParam(name = "id") Long id){
        return service.eliminarProyecto(id);
    }
    
    @WebMethod(operationName = "filter")
    public List<ProyectosDto> filter(@WebParam(name = "Administrador") AdministradorDto adm, @WebParam(name = "nombre") String nombre){
        return service.filtro(adm, nombre);
    }
    
    @WebMethod(operationName = "filter2")
    public List<ProyectosDto> filter2(@WebParam(name = "proNombre") String proNobre, @WebParam(name = "proLtecnico") String proLtecnico, @WebParam(name = "proPatrocinador") String proPatrocinador){
        return service.filtro2(proNobre, proLtecnico, proPatrocinador);
    }
}
