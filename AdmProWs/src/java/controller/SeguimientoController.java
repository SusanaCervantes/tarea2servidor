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
import model.SeguimientoDto;
import service.SeguimientoService;

/**
 *
 * @author Susana
 */
@WebService(serviceName = "SeguimientoController")
public class SeguimientoController {

    @EJB 
    SeguimientoService seguimientoService;
    
    @WebMethod(operationName = "guardarSeguimiento")
    public SeguimientoDto guardarSeguimiento(@WebParam(name = "seguimiento") SeguimientoDto seg) {
        return seguimientoService.guardarSeguimiento(seg);
    }
    
    @WebMethod(operationName = "getSeguimientos")
    public List<SeguimientoDto> getSeguimientos(@WebParam(name = "proId") Long proId) {
        return seguimientoService.getSeguimientos(proId);
    }
    
    @WebMethod(operationName = "eliminarSeguimiento")
    public String eliminarSeguimiento(@WebParam(name = "segId") Long id){
        return seguimientoService.eliminarSeguimiento(id);
    }
    
}
