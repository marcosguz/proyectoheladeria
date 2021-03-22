/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.TipoProducto;
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
public class TipoProductoDao extends GenericoDao<TipoProducto> {

    public TipoProductoDao() {
        super(TipoProducto.class);
    }
    
    public List<TipoProducto> buscarTipoProducto(){
        Query query = getEntityManager().createQuery("SELECT tp FROM TipoProducto tp WHERE tp.estadoTipoProducto=true");
        List<TipoProducto> listaTipoProducto = query.getResultList();
        return listaTipoProducto;
    }
    
}
