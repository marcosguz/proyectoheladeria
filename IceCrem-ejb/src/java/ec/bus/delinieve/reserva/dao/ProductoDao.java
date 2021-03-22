/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Producto;
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
public class ProductoDao extends GenericoDao<Producto> {

    public ProductoDao() {
        super(Producto.class);
    }
    
    public List<Producto> buscarProducto(){
        Query query = getEntityManager().createQuery("SELECT p FROM Producto p WHERE p.estadoProducto=true");
        List<Producto> listaProducto = query.getResultList();
        return listaProducto;
    }
    
}
