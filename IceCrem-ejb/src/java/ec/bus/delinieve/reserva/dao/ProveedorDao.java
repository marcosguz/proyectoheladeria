/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Proveedor;
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
public class ProveedorDao extends GenericoDao<Proveedor> {

    public ProveedorDao() {
        super(Proveedor.class);
    }
    
    public List<Proveedor> buscarProveedor(){
        Query query = getEntityManager().createQuery("SELECT prove FROM Proveedor prove WHERE prove.estadoProveedor=true");
        List<Proveedor> listaProveedor = query.getResultList();
        return listaProveedor;
    }
    
}
