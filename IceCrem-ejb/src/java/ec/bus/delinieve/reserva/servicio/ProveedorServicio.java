/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.ProveedorDao;
import ec.bus.delinieve.reserva.modelo.Proveedor;
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
public class ProveedorServicio {

    @EJB
    private ProveedorDao proveedorDao;
    
    public void guardar(Proveedor proveedor){
        proveedorDao.create(proveedor);
    }
    
    public List<Proveedor> buscarProveedor(){
        List<Proveedor> listaProveedor = proveedorDao.buscarProveedor();
        return  listaProveedor;
    }
    
}
