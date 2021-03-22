/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.TipoProductoDao;
import ec.bus.delinieve.reserva.modelo.TipoProducto;
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
public class TipoProductoServicio {

    @EJB
    private TipoProductoDao tipoProductoDao;
    
    public void guardar(TipoProducto tipoProducto){
        tipoProductoDao.create(tipoProducto);
    }
    
    public List<TipoProducto> buscarTipoProducto(){
        List<TipoProducto> listaTipoProducto = tipoProductoDao.buscarTipoProducto();
        return listaTipoProducto;
    }
    
}
