/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Administrador;
import model.AdministradorDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import util.CodigoRespuesta;

/**
 *
 * @author Susana
 */
@Stateless
public class AdministradorService {
    
    private static final Logger LOG = Logger.getLogger(AdministradorService.class.getName());
    
    @PersistenceContext(unitName = "AdmProWsPU")
    private EntityManager em; 
    
    public AdministradorDto guardarAdministrador(AdministradorDto admDto) {
        try {
            Administrador adm;
            if (admDto.getId()!= null && admDto.getId()> 0) {
                adm = em.find(Administrador.class, admDto.getId());
                if (adm == null) { //Boolean estado, String mensaje, String mensajeInterno
                    return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
                }
                adm.actualizar(admDto);
                adm = em.merge(adm);
            } else {
                adm = new Administrador(admDto);
                em.persist(adm);
            }
            em.flush();
            
            admDto = new AdministradorDto(adm);
            return admDto;//new Respuesta(true, CodigoRespuesta.CORRECTO, "", "Administrador", new AdministradorDto(adm));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el administrador.", ex);
            return null;//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el administrador.", "guardarAdministrador " + ex.getMessage());
        }
    }
    
    public List<AdministradorDto> getAdministradores(String nombre, String apellidos) {
        try {
            Query qryAdministrador = em.createNamedQuery("Administrador.findByNombreApellidos", Administrador.class);
            qryAdministrador.setParameter("nombre", nombre );
            qryAdministrador.setParameter("apellidos", apellidos );
            List<Administrador> administradores = qryAdministrador.getResultList();
            List<AdministradorDto> administradoresDto = new ArrayList<>();
            
            for (Administrador administrador : administradores) {
                administradoresDto.add(new AdministradorDto(administrador));
            }
            return administradoresDto;
        } catch (NoResultException ex) {
            LOG.log(Level.WARNING, "No hay resultados", ex);
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el administrador.", ex);
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "Ocurrio un error al buscar el admnistrador", ex.toString());
        }
    }
    
     public  List<AdministradorDto> getAdmiLogging(String usuario, String contrasena) {
        try {
            Query qryAdministrador = em.createNamedQuery("Administrador.findByUsuarioContrasena", Administrador.class);
            qryAdministrador.setParameter("usuario", usuario );
            qryAdministrador.setParameter("contrasena", contrasena );
            List<Administrador> administradores = qryAdministrador.getResultList();
            List<AdministradorDto> administradoresDto = new ArrayList<>();
            
            for (Administrador administrador : administradores) {
                administradoresDto.add(new AdministradorDto(administrador));
            }
            return administradoresDto;
            
           
        } catch (NoResultException ex) {
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario y la contrasena", ex);
            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "Ocurrio un error al buscar el admnistrador", ex.toString());
        }
    }
    
    
    
    
    public String eliminarAdministrador(Long id) {
        try {
            Administrador administrador;
            if (id != null && id > 0) {
                administrador = em.find(Administrador.class, id);
                if (administrador == null) {
                    return "No se encontro ningun administrador con esos datos";//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
                }else
                em.remove(administrador);
            } else {
                return "No se encontro ningun administrador con esos datos";//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
            }
            em.flush();
            return "Administrador eliminado con exito";//new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return "No se puede eliminar el administrador porque tiene relaciones con otros registros.";//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el administrador porque tiene relaciones con otros registros.", "eliminarAdministrador " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el administrador.", ex);
            return "Ocurrio un error al eliminar el administrador.";//new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el administrador.", "eliminarAdministrador " + ex.getMessage());
        }
    }
    
}
