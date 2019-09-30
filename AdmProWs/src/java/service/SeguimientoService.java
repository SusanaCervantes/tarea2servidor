/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Proyecto;
import model.Seguimiento;
import model.SeguimientoDto;

/**
 *
 * @author Susana
 */
@Stateless
public class SeguimientoService {
    
    private static final Logger LOG = Logger.getLogger(SeguimientoService.class.getName());
    
    @PersistenceContext(unitName = "AdmProWsPU")
    private EntityManager em; 
    
    public SeguimientoDto guardarSeguimiento(SeguimientoDto segDto) {
        try {
            Seguimiento seg;
            Proyecto pro = em.find(Proyecto.class, segDto.getProyecto().getProId());//;
            if (segDto.getId()!= null && segDto.getId()> 0) {
                seg = em.find(Seguimiento.class, segDto.getId());
                if (seg == null) { 
                    return null;
                }
                seg.actualizar(segDto);
                seg = em.merge(seg);
            } else {
                seg = new Seguimiento(segDto);
                seg.setProId(pro);
                em.persist(seg);
                em.refresh(pro);
            }
            em.flush();
            segDto = new SeguimientoDto(seg);
            return segDto;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el seguimiento.", ex);
            return null;
        }
    }
    
    public List<SeguimientoDto> getSeguimientos(Long proId) {
        try {
            Proyecto pro = em.find(Proyecto.class, proId);
            Query qrySeguimiento = em.createNamedQuery("Seguimiento.findByProid", Seguimiento.class); //Revisar
            qrySeguimiento.setParameter("proId", pro);
            List<Seguimiento> seguimientos = qrySeguimiento.getResultList();
            List<SeguimientoDto> seguimientosDto = new ArrayList<>();
            
            for (Seguimiento seguimiento : seguimientos) {
                seguimientosDto.add(new SeguimientoDto(seguimiento));
            }
            return seguimientosDto;
        } catch (NoResultException ex) {
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun seguimiento con esos datos", "No encontrado");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el seguimiento.", ex);
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "Ocurrio un error al buscar el segnistrador", ex.toString());
        }
    }
    
    public String eliminarSeguimiento(Long id) {
        try {
            Seguimiento seguimiento;
            if (id != null && id > 0) {
                seguimiento = em.find(Seguimiento.class, id);
                if (seguimiento == null) {
                    return "No se encontro ningun seguimiento con esos datos";//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun seguimiento con esos datos", "No encontrado");
                }else
                em.remove(seguimiento);
            } else {
                return "No se encontro ningun seguimiento con esos datos";//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun seguimiento con esos datos", "No encontrado");
            }
            em.flush();
            return "Seguimiento eliminado con exito";//new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return "No se puede eliminar el seguimiento porque tiene relaciones con otros registros.";//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el seguimiento porque tiene relaciones con otros registros.", "eliminarSeguimiento " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el seguimiento.", ex);
            return "Ocurrio un error al eliminar el seguimiento.";//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el seguimiento.", "eliminarSeguimiento " + ex.getMessage());
        }
    }
}
