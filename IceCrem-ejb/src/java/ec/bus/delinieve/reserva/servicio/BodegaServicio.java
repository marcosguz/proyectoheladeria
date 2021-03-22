/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.BodegaDao;
import ec.bus.delinieve.reserva.modelo.Bodega;
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
public class BodegaServicio {

    @EJB
    private BodegaDao bodegaDao;
    
    public void guardar(Bodega bodega){
        bodegaDao.create(bodega);
    }
    
    public List<Bodega> buscarBodega(){
        List<Bodega> listaBodega = bodegaDao.buscarBodega();
        return listaBodega;
    }
    
//    public List<Bodega> buscarCantidadProductos(){
//        List<Bodega> listaCantidadProductos = bodegaDao.buscarCantidadProductos();
//        return listaCantidadProductos;
//    }
    
}
