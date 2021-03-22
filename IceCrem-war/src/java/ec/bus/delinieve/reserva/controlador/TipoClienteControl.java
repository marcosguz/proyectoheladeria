/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.TipoCliente;
import ec.bus.delinieve.reserva.servicio.TipoClienteServicio;
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
@Named(value = "tipoClienteControl")
@ViewScoped
public class TipoClienteControl implements Serializable{

    private TipoCliente tipoCliente;
    private List<TipoCliente> listaTipoCliente;
    
    @EJB
    private TipoClienteServicio tipoClienteServicio;
    
    @PostConstruct
    public void init(){
        tipoCliente = new TipoCliente(); 
        buscarTipoCliente();
    }
    
    public void buscarTipoCliente(){
        listaTipoCliente = tipoClienteServicio.buscarTipoCliente();
    }
    
    public void guardar(){
        tipoClienteServicio.guardar(tipoCliente);
        limpiar();
        buscarTipoCliente();
    }
    
    public void limpiar(){
        tipoCliente = new TipoCliente();
    }
    
    public void actualizar(TipoCliente tipoCliente){
        this.tipoCliente = tipoCliente;
    }
    

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<TipoCliente> getListaTipoCliente() {
        return listaTipoCliente;
    }

    public void setListaTipoCliente(List<TipoCliente> listaTipoCliente) {
        this.listaTipoCliente = listaTipoCliente;
    }
    
}
