/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.ClienteDao;
import ec.bus.delinieve.reserva.modelo.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marcos
 */
@Stateless
@LocalBean
public class ClienteServicio {

    @EJB
    private ClienteDao clienteDao;
    
    public void guardar(Cliente cliente){
        clienteDao.create(cliente);
    }
    
    public List<Cliente> buscarCliente(){
        List<Cliente> listaCliente = clienteDao.buscarCliente();
        return listaCliente;
    }
    
    public Integer devolverUltimoCliente(){
        return clienteDao.devolverUltimoCliente();
    }
    
    public Cliente devolverClienteId(Integer idCliente){
        return clienteDao.devolverClienteId(idCliente);
    }
    
}
