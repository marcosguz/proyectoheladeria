/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.dao.DetalleFacturaDao;
import ec.bus.delinieve.reserva.modelo.DetalleFactura;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marcos
 */
class DetalleFacturaSericio {
    
    @EJB
    private DetalleFacturaDao detalleFacturaDao;
    
    public void guardar(DetalleFactura detalleFactura){
        detalleFacturaDao.create(detalleFactura);
    }
    
    public List<DetalleFactura> buscarDetalleFactura(){
        List<DetalleFactura> listaDetalleFactura = detalleFacturaDao.buscarDetalleFactura();
        return listaDetalleFactura;
    }
}
