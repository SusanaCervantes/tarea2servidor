/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Administrador;
import Model.AdministradorDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static org.jboss.weld.logging.BeanLogger.LOG;

/**
 *
 * @author Susana
 */
@Stateless
public class AdministradorService {
    
    private static final Logger LOG = Logger.getLogger(AdministradorService.class.getName());
    
    @PersistenceContext(unitName = "AdmProWSPU")
    private EntityManager em; 
    
    public String guardarAdministrador(AdministradorDto admDto) {
        try {
            Administrador adm;
            if (admDto.getId()!= null && admDto.getId()> 0) {
                adm = em.find(Administrador.class, admDto.getId());
                if (adm == null) {
                    return "No se encrontró el administrador a modificar.";
                }
                adm.actualizar(admDto);
                adm = em.merge(adm);
            } else {
                adm = new Administrador(admDto);
                em.persist(adm);
            }
            em.flush();
            return "Administrador guardado con exito";
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el administrador.", ex);
            return "Ocurrio un error al guardar el administrador." + ex.getMessage();
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
            return null;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el administrador.", ex);
            return null;
        }
    }
}
