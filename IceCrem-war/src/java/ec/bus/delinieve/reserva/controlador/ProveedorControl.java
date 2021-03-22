/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Persona;
import ec.bus.delinieve.reserva.modelo.Proveedor;
import ec.bus.delinieve.reserva.servicio.ProveedorServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Marcos
 */
@Named(value = "proveedorControl")
@ViewScoped
public class ProveedorControl implements Serializable{

    private Proveedor proveedor;
    private List<Proveedor> listaProveedor;
    
    @EJB
    private ProveedorServicio proveedorServicio;
    
    @PostConstruct
    public void init(){
        proveedor = new Proveedor();
        proveedor.setIdPersona(new Persona());
        buscarProveedor();
    }
    
    public void buscarProveedor(){
        listaProveedor = proveedorServicio.buscarProveedor();
    }
    
    public void guardar(){
        proveedorServicio.guardar(proveedor);
        limpiar();
        buscarProveedor();
    }
    
    public void limpiar(){
        proveedor = new Proveedor();
    }
    
    public void actualizar(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
    
    
    
}
