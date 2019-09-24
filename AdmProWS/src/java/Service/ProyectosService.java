/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.ProyectosDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Proyecto;

/**
 *
 * @author ivana
 */
@Stateless
public class ProyectosService {
    
    private static final Logger LOG = Logger.getLogger(ProyectosService.class.getName());
    @PersistenceContext(unitName = "AdmProWsPU")
    private EntityManager em; 
    
    public List<ProyectosDto> getAll(){
        try{
            Query query = em.createNamedQuery("Proyecto.findAll", Proyecto.class);
            List<Proyecto> lista = query.getResultList();
            List<ProyectosDto> lista2 = new ArrayList<>(); 
            for(Proyecto pro : lista){
                lista2.add(new ProyectosDto(pro));
            }
            return lista2;
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            return null;
        }
    }
}
