/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Administrador;
import Model.AdministradorDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
