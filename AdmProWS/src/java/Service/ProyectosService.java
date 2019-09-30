/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLIntegrityConstraintViolationException;
import model.ProyectosDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Administrador;
import model.AdministradorDto;
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
    
    public ProyectosDto guardarProyecto(ProyectosDto proDto) {
        try {
            Proyecto pro;
            if (proDto.getProId() > 0) {
                pro = em.find(Proyecto.class, proDto.getProId());
                if (pro == null) {
                    return null;
                }
                pro.actualizar(proDto);
                pro = em.merge(pro);
            } else {
                pro = new Proyecto(proDto);
                em.persist(pro);
            }
            em.flush();
            
            proDto = new ProyectosDto(pro);
            return proDto;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el proyecto.", ex);
            return null;
        }
    }
    
    public Integer eliminarProyecto(Long id) {
        try {
            Proyecto proyecto;
            if (id != null && id > 0) {
                proyecto = em.find(Proyecto.class, id);
                if (proyecto == null) {
                    return 0;
                }else
                em.remove(proyecto);
            } else {
                return 0;
            }
            em.flush();
            return 1;
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return 2;
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el administrador.", ex);
            return 3;
        }
    }
    
    public List<ProyectosDto> filtro(AdministradorDto admDto, String nombre){
        try{
            Administrador adm = new Administrador(admDto);
            Query query = em.createNamedQuery("Proyecto.filtro", Proyecto.class);
            query.setParameter("admId", adm);
            query.setParameter("proNombre", nombre);
            List<Proyecto> list = query.getResultList();
            List<ProyectosDto> retorno = new ArrayList();
            for(Proyecto pro : list){
                retorno.add(new ProyectosDto(pro));
            }
            return retorno;
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    /**
     * 
     * @param nom nombre del proyecto
     * @param lt lider tecnico
     * @param p patrocinador
     * @return 
     */
     public List<ProyectosDto> filtro2(String nom, String lt, String p){
        try{
            Query query = em.createNamedQuery("Proyecto.filtro2", Proyecto.class);
            query.setParameter("proNombre", nom);
            query.setParameter("proLtecnico", lt);
            query.setParameter("proPatrocinador", p);
            List<Proyecto> list = query.getResultList();
            List<ProyectosDto> retorno = new ArrayList();
            for(Proyecto pro : list){
                retorno.add(new ProyectosDto(pro));
            }
            return retorno;
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    
}
