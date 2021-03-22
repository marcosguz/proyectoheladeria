/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Bodega;
import ec.bus.delinieve.reserva.modelo.Empleado;
import ec.bus.delinieve.reserva.modelo.Proveedor;
import ec.bus.delinieve.reserva.servicio.BodegaServicio;
import ec.bus.delinieve.reserva.servicio.EmpleadoServicio;
import ec.bus.delinieve.reserva.servicio.ProveedorServicio;
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
@Named(value = "bodegaControl")
@ViewScoped
public class BodegaControl implements Serializable{
    
    private Bodega bodega;
    private List<Bodega> listaBodega;
    private List<SelectItem> listaItemsEmpleado;
    private Map<Integer, Empleado> mapaEmpleado;
    private List<SelectItem> listaItemsProveedor;
    private Map<Integer, Proveedor> mapaProveedor;
    private List<SelectItem> listaItemsEmpresa;
    private Map<Integer, Proveedor> mapaEmpresa;
    private Integer idEmpleado;
    private Integer idProveedor;
    private Date fecha;
    
    
    @EJB
    private BodegaServicio bodegaServicio;
    
    @EJB
    private EmpleadoServicio empleadoServicio;
    
    @EJB
    private ProveedorServicio proveedorServicio;

    @PostConstruct
    public void init(){
        bodega = new Bodega();
        buscarBodega();
        llenarItemsEmpleado();
        llenarItemsProveedor();
        llenarItemsEmpresa();
        fecha = new Date();
    }
    
    public void buscarBodega(){
        listaBodega = bodegaServicio.buscarBodega();
    }
    
    private void llenarItemsEmpleado(){
        List<Empleado> listaEmpleado = empleadoServicio.buscarEmpleado();
        listaItemsEmpleado = new ArrayList<>();
        mapaEmpleado = new HashMap<>();
        for (Empleado empleado: listaEmpleado) {
            SelectItem item = new SelectItem(empleado.getIdEmpleado(), empleado.getIdPersona().getApellido()+" "+empleado.getIdPersona().getNombre());
            listaItemsEmpleado.add(item);
            mapaEmpleado.put(empleado.getIdEmpleado(), empleado);
        }
    }
    
    private void llenarItemsProveedor(){
        List<Proveedor> listaProveedor = proveedorServicio.buscarProveedor();
        listaItemsProveedor = new ArrayList<>();
        mapaProveedor = new HashMap<>();
        for (Proveedor proveedor : listaProveedor) {
            SelectItem itemProveedor = new SelectItem(proveedor.getIdProveedor(), proveedor.getIdPersona().getApellido()+" "+proveedor.getIdPersona().getNombre());
            listaItemsProveedor.add(itemProveedor);
            mapaProveedor.put(proveedor.getIdProveedor(), proveedor);
        }
    }
    
    private void llenarItemsEmpresa(){
        List<Proveedor> listaEmpresa = proveedorServicio.buscarProveedor();
        listaItemsEmpresa = new ArrayList<>();
        mapaEmpresa = new HashMap<>();
        for (Proveedor proveedor : listaEmpresa) {
            SelectItem itemEmpresa = new SelectItem(proveedor.getIdProveedor(), proveedor.getEmpresa());
            listaItemsEmpresa.add(itemEmpresa);
            mapaEmpresa.put(proveedor.getIdProveedor(), proveedor);
        }
    }
    
    public void guardar(){
        Empleado empleado = mapaEmpleado.get(idEmpleado);
        bodega.setIdEmpleado(empleado);
        Proveedor proveedor = mapaProveedor.get(idProveedor);
        bodega.setIdProveedor(proveedor);
        bodegaServicio.guardar(bodega);
        limpiar();
        buscarBodega();
    }
    
    public void limpiar(){
        bodega = new Bodega();
        idEmpleado = null;
        idProveedor = null;
    }
    
    public void actualizar(Bodega bodega){
        this.bodega = bodega;
        this.idEmpleado = bodega.getIdEmpleado().getIdEmpleado();
        this.idProveedor = bodega.getIdProveedor().getIdProveedor();
    }
    
    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Bodega> getListaBodega() {
        return listaBodega;
    }

    public void setListaBodega(List<Bodega> listaBodega) {
        this.listaBodega = listaBodega;
    }

    public List<SelectItem> getListaItemsEmpleado() {
        return listaItemsEmpleado;
    }

    public void setListaItemsEmpleado(List<SelectItem> listaItemsEmpleado) {
        this.listaItemsEmpleado = listaItemsEmpleado;
    }

    public List<SelectItem> getListaItemsProveedor() {
        return listaItemsProveedor;
    }

    public void setListaItemsProveedor(List<SelectItem> listaItemsProveedor) {
        this.listaItemsProveedor = listaItemsProveedor;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public List<SelectItem> getListaItemsEmpresa() {
        return listaItemsEmpresa;
    }

    public void setListaItemsEmpresa(List<SelectItem> listaItemsEmpresa) {
        this.listaItemsEmpresa = listaItemsEmpresa;
    }  

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
