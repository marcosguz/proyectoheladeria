/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Caracteristica;
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
public class CaracteristicaDao extends GenericoDao<Caracteristica> {

    public CaracteristicaDao() {
        super(Caracteristica.class);
    }
    
    public List<Caracteristica> buscarCaracteristica(){
        Query query = getEntityManager().createQuery("SELECT c FROM Caracteristica c WHERE c.estado=true");
        List<Caracteristica> listaCaracteristica = query.getResultList();
        return listaCaracteristica;
    }
    
}
