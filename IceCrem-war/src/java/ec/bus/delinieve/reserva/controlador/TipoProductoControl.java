/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.TipoProducto;
import ec.bus.delinieve.reserva.servicio.TipoProductoServicio;
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
@Named(value = "tipoProductoControl")
@ViewScoped
public class TipoProductoControl implements Serializable{
    
    @EJB
    private TipoProductoServicio tipoProductoServicio;

    private TipoProducto tipoProducto;
    private List<TipoProducto> listaTipoProducto;
    
    
    @PostConstruct
    public void init(){
        buscarTipoProducto();
        tipoProducto = new TipoProducto();
    }
    
    public void buscarTipoProducto(){
        listaTipoProducto = tipoProductoServicio.buscarTipoProducto();
    }
        
    public void seleccionarTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }

    public void guardar(){
        tipoProductoServicio.guardar(tipoProducto);
        limpiar();
        buscarTipoProducto();
    }
    
    public void limpiar(){
        tipoProducto = new TipoProducto();
    }
    
    public List<TipoProducto> getListaTipoProducto() {
        return listaTipoProducto;
    }

    public void setListaTipoProducto(List<TipoProducto> listaTipoProducto) {
        this.listaTipoProducto = listaTipoProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}
