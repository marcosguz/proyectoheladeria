/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.DetalleFactura;
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
public class DetalleFacturaDao extends GenericoDao<DetalleFactura> {

    public DetalleFacturaDao() {
        super(DetalleFactura.class);
    }
    
    public List<DetalleFactura> buscarDetalleFactura(){
        Query query = getEntityManager().createQuery("SELECT db FROM DetalleBodega db");
        List<DetalleFactura> listaDetalleFactura = query.getResultList();
        return listaDetalleFactura;
    }
    
}
