/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.PuestoTrabajo;
import ec.bus.delinieve.reserva.servicio.PuestoTrabajoServicio;
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
@Named(value = "puestoTrabajoControl")
@ViewScoped
public class PuestoTrabajoControl implements Serializable{

    private PuestoTrabajo puestoTrabajo;
    private List<PuestoTrabajo> listaPuestoTrabajo;
    
    @EJB
    private PuestoTrabajoServicio puestoTrabajoServicio;

    @PostConstruct
    public void init(){
        puestoTrabajo = new PuestoTrabajo();
        buscarPuestoTrabajo();
    }
    
    public void buscarPuestoTrabajo(){
        listaPuestoTrabajo = puestoTrabajoServicio.buscarPuestoTrabajo();
    }
    
    public void guardar(){
        puestoTrabajoServicio.guardar(puestoTrabajo);
        limpiar();
        buscarPuestoTrabajo();
    }
    
    public void limpiar(){
        puestoTrabajo = new PuestoTrabajo();
    }
    
    public void actualizar(PuestoTrabajo puestoTrabajo){
        this.puestoTrabajo = puestoTrabajo;
    }
            
    
    public PuestoTrabajo getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public List<PuestoTrabajo> getListaPuestoTrabajo() {
        return listaPuestoTrabajo;
    }

    public void setListaPuestoTrabajo(List<PuestoTrabajo> listaPuestoTrabajo) {
        this.listaPuestoTrabajo = listaPuestoTrabajo;
    }
    
    
    
}
