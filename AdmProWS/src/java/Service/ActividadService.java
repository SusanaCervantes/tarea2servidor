/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablo-VE
 */
@Stateless
public class ActividadService {

    private static final Logger LOG = Logger.getLogger(ActividadService.class.getName());
    
    @PersistenceContext(unitName = "AdmProWsPU")
    private EntityManager em; 
    
    
//     public List<ActividadDto> getAdministradores(String nombre, String apellidos) {
//        try {
//            Query qryAdministrador = em.createNamedQuery("Administrador.findByNombreApellidos", Administrador.class);
//            qryAdministrador.setParameter("nombre", nombre );
//            qryAdministrador.setParameter("apellidos", apellidos );
//            List<Administrador> administradores = qryAdministrador.getResultList();
//            List<AdministradorDto> administradoresDto = new ArrayList<>();
//            
//            for (Administrador administrador : administradores) {
//                administradoresDto.add(new AdministradorDto(administrador));
//            }
//            return administradoresDto;
//        } catch (NoResultException ex) {
//            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro ningun administrador con esos datos", "No encontrado");
//        } catch (Exception ex) {
//            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el administrador.", ex);
//            return null;//new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "Ocurrio un error al buscar el admnistrador", ex.toString());
//        }
//    }
    
}
