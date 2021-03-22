/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.TipoCliente;
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
public class TipoClienteDao extends GenericoDao<TipoCliente> {

    public TipoClienteDao() {
        super(TipoCliente.class);
    }
    
    public List<TipoCliente> buscarTipoCliente(){
        Query query = getEntityManager().createQuery("SELECT tc FROM TipoCliente tc");
        List<TipoCliente> listaTipoCliente = query.getResultList();
        return listaTipoCliente;
    }
}
