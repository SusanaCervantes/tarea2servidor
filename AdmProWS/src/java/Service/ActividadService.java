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
import model.Actividad;
import model.ActividadDto;
import model.Proyecto;

/**
 *
 * @author Pablo-VE
 */
@Stateless
public class ActividadService {

    private static final Logger LOG = Logger.getLogger(ActividadService.class.getName());
    
    @PersistenceContext(unitName = "AdmProWsPU")
    private EntityManager em; 
    
    
    public ActividadDto guardarSeguimiento(ActividadDto actDto) {
        try {
            Actividad act;
            Proyecto pro = em.find(Proyecto.class, new Long(1));//segDto.getProyecto().getProId());
            if (actDto.getId()!= null && actDto.getId()> 0) {
                act = em.find(Actividad.class, actDto.getId());
                if (act == null) { 
                    return null;
                }
                act.actualizarAct(actDto);
                act = em.merge(act);
            } else {
                act = new Actividad(actDto);
                act.setProId(pro);
                em.persist(act);
                em.refresh(pro);
            }
            em.flush();
            actDto = new ActividadDto(act);
            return actDto;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la actividad.", ex);
            return null;
        }
    }
    
    public List<ActividadDto> getActividades(Long proId) {
            try {
                Proyecto pro = em.find(Proyecto.class, proId);
                Query qrySeguimiento = em.createNamedQuery("Actividad.findByPro", Actividad.class); //Revisar
                qrySeguimiento.setParameter("proId", pro);
                List<Actividad> actividades = qrySeguimiento.getResultList();
                List<ActividadDto> actividadesDto = new ArrayList<>();

                for (Actividad actividad : actividades) {
                    actividadesDto.add(new ActividadDto(actividad));
                }
                return actividadesDto;
            } catch (NoResultException ex) {
                return null;
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "Ocurrio un error al consultar la actividad.", ex);
                return null;
            }
        }
    
    public String eliminarAct(Long id) {
        try {
            Actividad actividad;
            if (id != null && id > 0) {
                actividad = em.find(Actividad.class, id);
                if (actividad == null) {
                    return "No se encontro ninguna actividad con esos datos";
                }else
                em.remove(actividad);
            } else {
                return "No se encontro ninguna actividad con esos datos";
            }
            em.flush();
            return "Actividad eliminada con exito";
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return "No se puede eliminar la actividad porque tiene relaciones con otros registros.";//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el seguimiento porque tiene relaciones con otros registros.", "eliminarSeguimiento " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al eliminar la actividad.", ex);
            return "Ocurrio un error al eliminar la actividad.";
        }
    }
    
    
    
}
