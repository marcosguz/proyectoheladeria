/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.CaracteristicaDao;
import ec.bus.delinieve.reserva.modelo.Caracteristica;
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
public class CaracteristicaServicio {

    @EJB
    private CaracteristicaDao caracteristicaDao;
    
    public void guardar(Caracteristica caracteristica){
        caracteristicaDao.create(caracteristica);
    }
    
    public List<Caracteristica> buscarCaracteristica(){
        List<Caracteristica> listaCaracteristica = caracteristicaDao.buscarCaracteristica();
        return listaCaracteristica;
    }
    
}
