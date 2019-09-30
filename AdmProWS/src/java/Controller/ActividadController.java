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
import model.ActividadDto;
import service.ActividadService;

/**
 *
 * @author Susana
 */
@WebService(serviceName = "ActividadController")
public class ActividadController {
@EJB 
    ActividadService actividadService;
    
    @WebMethod(operationName = "guardarActividad")
    public ActividadDto guardarActividad(@WebParam(name = "seguimiento") ActividadDto act) {
        return actividadService.guardarActividad(act);
    }
    
    @WebMethod(operationName = "getActividades")
    public List<ActividadDto> getActividades(@WebParam(name = "proId1") Long proId1) {
        return actividadService.getActividades(proId1);
    }
    
    @WebMethod(operationName = "eliminarAct")
    public String eliminarAct(@WebParam(name = "actId") Long id){
        return actividadService.eliminarAct(id);
    }
}
