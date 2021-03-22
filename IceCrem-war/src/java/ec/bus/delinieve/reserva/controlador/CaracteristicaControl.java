/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Caracteristica;
import ec.bus.delinieve.reserva.servicio.CaracteristicaServicio;
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
@Named(value = "caracteristicaControl")
@ViewScoped
public class CaracteristicaControl implements Serializable{
    
    private Caracteristica caracteristica;
    private List<Caracteristica> listaCaracteristica;
    
    @EJB
    private CaracteristicaServicio caracteristicaServicio;
    
    @PostConstruct
    public void init(){
        buscarCaracteristica();
        caracteristica = new Caracteristica();
    }
    
    public void buscarCaracteristica(){
        listaCaracteristica = caracteristicaServicio.buscarCaracteristica();
    }
    
    public void seleccionarCaracteristica(Caracteristica caracteristica){
        this.caracteristica = caracteristica;
    }
    
    public void guardar(){
        caracteristicaServicio.guardar(caracteristica);
        limpiar();
        buscarCaracteristica();
    }
    
    public void limpiar(){
        caracteristica = new Caracteristica();
    }
       
    

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public List<Caracteristica> getListaCaracteristica() {
        return listaCaracteristica;
    }

    public void setListaCaracteristica(List<Caracteristica> listaCaracteristica) {
        this.listaCaracteristica = listaCaracteristica;
    }
    
        
}
