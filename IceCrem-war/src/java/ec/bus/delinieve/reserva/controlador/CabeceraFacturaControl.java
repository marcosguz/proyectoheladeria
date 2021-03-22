/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.CabeceraFactura;
import ec.bus.delinieve.reserva.modelo.DetalleFactura;
import ec.bus.delinieve.reserva.modelo.Producto;
import ec.bus.delinieve.reserva.servicio.ProductoServicio;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "cabeceraFacturaControl")
@ViewScoped
public class CabeceraFacturaControl implements Serializable{

    private CabeceraFactura cabeceraFactura;
    private DetalleFactura detalleFactura;
    private List<DetalleFactura> listaDetalleFactura;
    private List<SelectItem> listaItemsProductos;
    private Map<Integer, Producto> mapaProducto;
    private Integer idProducto;
    
    @EJB
    private ProductoServicio productoServicio;
    
    @EJB
    private DetalleFacturaSericio detalleFacturaSericio;
    
    @PostConstruct
    public void init(){
        cabeceraFactura = new CabeceraFactura();
        detalleFactura = new DetalleFactura();
//        llenarItemsProducto();
        listaDetalleFactura = new ArrayList<>();
    }
    
//    private void llenarItemsProducto(){
//        List<Producto> listaProducto = productoServicio.buscarProducto();
//        listaItemsProductos = new ArrayList<>();
//        mapaProducto = new HashMap<>();
//        for (Producto producto : listaProducto) {
//            SelectItem itemProducto = new SelectItem(producto.getIdProducto(), producto.getNombreProducto());
//            listaItemsProductos.add(itemProducto);
//            mapaProducto.put(producto.getIdProducto(), producto);
//        }
//    }
    
    public void agregarProducto(){
        detalleFactura.setIdCabeceraFeactura(cabeceraFactura);
        Producto producto = mapaProducto.get(idProducto);  
        detalleFactura.setIdProducto(producto);
        listaDetalleFactura.add(detalleFactura);   
    }
    
    
    public void guardar(){
        cabeceraFactura.setDetalleFacturaList(listaDetalleFactura);
    }
    
    
    public void totalProductos(){
        
    }

    public CabeceraFactura getCabeceraFactura() {
        return cabeceraFactura;
    }

    public void setCabeceraFactura(CabeceraFactura cabeceraFactura) {
        this.cabeceraFactura = cabeceraFactura;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public List<SelectItem> getListaItemsProductos() {
        return listaItemsProductos;
    }

    public void setListaItemsProductos(List<SelectItem> listaItemsProductos) {
        this.listaItemsProductos = listaItemsProductos;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
}
