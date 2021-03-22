/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.TipoClienteDao;
import ec.bus.delinieve.reserva.modelo.TipoCliente;
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
public class TipoClienteServicio {

    @EJB
    private TipoClienteDao tipoClienteDao;
    
    public void guardar(TipoCliente tipoCliente){
        tipoClienteDao.create(tipoCliente);
    }
    
    public List<TipoCliente> buscarTipoCliente(){
        List<TipoCliente> listaTipoCliente = tipoClienteDao.buscarTipoCliente();
        return listaTipoCliente;
    }
}
