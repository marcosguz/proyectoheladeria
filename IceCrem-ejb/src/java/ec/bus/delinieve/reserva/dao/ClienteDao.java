/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcos
 */
@Stateless
public class ClienteDao extends GenericoDao<Cliente> {

    public ClienteDao() {
        super(Cliente.class);
    }
    
    public List<Cliente> buscarCliente(){
        Query query = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.estadoCliente= true");
        List<Cliente> listaCliente = query.getResultList();
        return listaCliente;
    }
    
    public Integer devolverUltimoCliente(){
        Query query = getEntityManager().createNativeQuery("SELECT c.id_cliente FROM Cliente c WHERE c.id_cliente=(SELECT MAX(id_cliente) FROM Cliente c WHERE c.estado_cliente=true)");
        Object obj = query.getSingleResult();
        return (Integer) obj;
    }
    
    public Cliente devolverClienteId(Integer idCliente) {
        TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.estadoCliente=true AND c.idCliente =:idCliente", Cliente.class);
        Cliente employee = query.setParameter("idCliente", idCliente).getSingleResult();
        return employee;
    }
    
    
}
