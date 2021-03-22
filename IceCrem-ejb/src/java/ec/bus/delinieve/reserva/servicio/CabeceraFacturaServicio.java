/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;


import ec.bus.delinieve.reserva.dao.CabeceraFacturaDao;
import ec.bus.delinieve.reserva.modelo.CabeceraFactura;
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
public class CabeceraFacturaServicio {

    @EJB
    private CabeceraFacturaDao cabeceraFacturaDao;
    
    public void guardar(CabeceraFactura cabeceraFactura){
        cabeceraFacturaDao.create(cabeceraFactura);
    }
    
    public List<CabeceraFactura> buscarCabeceraFactura(){
        List<CabeceraFactura> listaCabeceraFactura = cabeceraFacturaDao.buscarCabeceraFactura();
        return listaCabeceraFactura;
    }
    
    public Integer devolverUltimaCabeceraFactura(){
        return cabeceraFacturaDao.devolverUltimaCabecera();
    }
    
    public CabeceraFactura devolverCabeceraId(Integer idCabera){
        return cabeceraFacturaDao.devolverCabeceraId(idCabera);
    }
    
}
