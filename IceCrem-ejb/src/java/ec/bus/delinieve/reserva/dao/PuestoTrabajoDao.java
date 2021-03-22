/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.PuestoTrabajo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcos
 */
@Stateless
public class PuestoTrabajoDao extends GenericoDao<PuestoTrabajo> {
    
    public PuestoTrabajoDao() {
        super(PuestoTrabajo.class);
    }
    
    public List<PuestoTrabajo> buscarPuestoTrabajo(){
        Query query = getEntityManager().createQuery("SELECT pt FROM PuestoTrabajo pt WHERE pt.estadoPuestoTrabajo=true");
        List<PuestoTrabajo> listaPuestoTrabajo = query.getResultList();
        return listaPuestoTrabajo;
    }
}
