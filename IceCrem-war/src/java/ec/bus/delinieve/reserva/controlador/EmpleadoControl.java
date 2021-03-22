/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Empleado;
import ec.bus.delinieve.reserva.modelo.Persona;
import ec.bus.delinieve.reserva.modelo.PuestoTrabajo;
import ec.bus.delinieve.reserva.servicio.EmpleadoServicio;
import ec.bus.delinieve.reserva.servicio.PuestoTrabajoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Marcos
 */
@Named(value = "empleadoControl")
@ViewScoped
public class EmpleadoControl implements Serializable{

    private Empleado empleado;
    private List<Empleado> listaEmpleado;
    private List<SelectItem> selectPuestoTrabajo;
    private Integer idPuestoTrabajo;
    private Map<Integer, PuestoTrabajo> mapaPuestoTrabajo;
    private Date fecha;
    
    @EJB
    private PuestoTrabajoServicio puestoTrabajoServicio;
    
    @EJB
    private EmpleadoServicio empleadoServicio;
    
    @PostConstruct
    public void init(){
        empleado = new Empleado();
        empleado.setIdPersona(new Persona());
        crearSelectItemPuestoTrabajo(buscarPuestoTrabajo());
        buscarEmpleado();
        fecha = new Date();
    }
    
    private void buscarEmpleado(){
        listaEmpleado = empleadoServicio.buscarEmpleado();
    }
    
    public List<PuestoTrabajo> buscarPuestoTrabajo(){
        List<PuestoTrabajo> listaPuestoTrabajo = puestoTrabajoServicio.buscarPuestoTrabajo();
        mapaPuestoTrabajo = new HashMap<>();
        for (PuestoTrabajo puestoTrabajo : listaPuestoTrabajo) {
            mapaPuestoTrabajo.put(puestoTrabajo.getIdPuestoTrabajo(), puestoTrabajo);
        }
        return listaPuestoTrabajo;
    }
    
    private void crearSelectItemPuestoTrabajo(List<PuestoTrabajo> listaPuestoTrabajo){
        selectPuestoTrabajo = new ArrayList<>();
        for (PuestoTrabajo puestoTrabajo : listaPuestoTrabajo) {
            SelectItem itemEmpleado = new SelectItem(puestoTrabajo.getIdPuestoTrabajo(), puestoTrabajo.getNombrePuestoTrabajo());
            selectPuestoTrabajo.add(itemEmpleado);
        }
    }

    public void guardar(){
        PuestoTrabajo puestoTrabajo = mapaPuestoTrabajo.get(idPuestoTrabajo);
        empleado.setIdPuestoTrabajo(puestoTrabajo);
        empleadoServicio.guardar(empleado);
        limpiar();
        buscarEmpleado();
    }
    
    public void limpiar(){
       this.empleado = new Empleado();
       this.idPuestoTrabajo = null;
    }
    
    public void actualizar(Empleado empleado){
        this.empleado = empleado;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<SelectItem> getSelectPuestoTrabajo() {
        return selectPuestoTrabajo;
    }

    public void setSelectPuestoTrabajo(List<SelectItem> selectPuestoTrabajo) {
        this.selectPuestoTrabajo = selectPuestoTrabajo;
    }

    public Integer getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
}
