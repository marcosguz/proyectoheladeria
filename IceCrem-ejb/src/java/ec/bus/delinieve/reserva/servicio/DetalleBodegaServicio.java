/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.DetalleBodegaDao;
import ec.bus.delinieve.reserva.modelo.DetalleBodega;
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
public class DetalleBodegaServicio {

    @EJB
    private DetalleBodegaDao detalleBodegaDao;
    
    public void guardar(DetalleBodega detalleBodega){
        detalleBodegaDao.create(detalleBodega);
    }
    
    public List<DetalleBodega> buscarDetalleBodega(){
        List<DetalleBodega> listaDetalleBodega = detalleBodegaDao.findAll();
        return listaDetalleBodega;
    }
}
