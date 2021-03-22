/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.EmpleadoDao;
import ec.bus.delinieve.reserva.modelo.Empleado;
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
public class EmpleadoServicio {

    @EJB
    private EmpleadoDao empleadoDao;
    
    public void guardar(Empleado empleado){
        empleadoDao.create(empleado);
    }
    
    public List<Empleado> buscarEmpleado(){
        List<Empleado> listaEmpleado = empleadoDao.buscarEmpleado();
        return listaEmpleado;
    }
    
    public Empleado devolverEmpleadoIde(Integer idEmpleado){
        return empleadoDao.devolverEmpleadoId(idEmpleado);
    }
    
}
