/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.PuestoTrabajoDao;
import ec.bus.delinieve.reserva.modelo.PuestoTrabajo;
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
public class PuestoTrabajoServicio {
    
    @EJB
    private PuestoTrabajoDao puestoTrabajoDao;
    
    public void guardar(PuestoTrabajo puestoTrabajo){
        puestoTrabajoDao.create(puestoTrabajo);
    }
    
    public List<PuestoTrabajo> buscarPuestoTrabajo(){
        List<PuestoTrabajo> listaPuestoTrabajo = puestoTrabajoDao.buscarPuestoTrabajo();
        return listaPuestoTrabajo;
    }
}
