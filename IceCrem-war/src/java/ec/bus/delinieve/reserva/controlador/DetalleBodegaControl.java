/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Bodega;
import ec.bus.delinieve.reserva.modelo.DetalleBodega;
import ec.bus.delinieve.reserva.modelo.DetalleFactura;
import ec.bus.delinieve.reserva.modelo.Producto;
import ec.bus.delinieve.reserva.servicio.BodegaServicio;
import ec.bus.delinieve.reserva.servicio.ProductoServicio;
import java.io.Serializable;
import java.lang.reflect.Array;
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
@Named(value = "detalleBodegaControl")
@ViewScoped
public class DetalleBodegaControl implements Serializable{

    private DetalleBodega detalleBodega;
    private Bodega bodega;
    private List<Bodega> listaBodega;
    private DetalleFactura detalleFactura;
    private List<DetalleBodega> listaDetalleBodega;
    private List<SelectItem> listaItemsProductos;
    private Map<Integer, Producto> mapaProducto;
    private Integer idProducto;
    
    @EJB
    private ProductoServicio productoServicio;
    
    @EJB
    private BodegaServicio bodegaServicio;
    
    @PostConstruct
    public void init(){
        buscarBodega();
        detalleBodega = new DetalleBodega();  
    }
    
    public void buscarBodega(){
        listaBodega = bodegaServicio.buscarBodega();
    }
    
//    private void llenarItemsProductos(){
//        List<Producto> listaProducto = productoServicio.buscarProducto();
//        listaItemsProductos = new ArrayList<>();
//        mapaProducto = new HashMap<>();
//        for (Producto producto : listaProducto) {
//            SelectItem itemProducto = new SelectItem(producto.getIdProducto(), producto.getNombreProducto());
//            listaItemsProductos.add(itemProducto);
//            mapaProducto.put(producto.getIdProducto(), producto);
//        }
//    }
    
//    public void actualizarProductos(){//1 factura  //ID productos          //su cantidad que se vendio //20                                 //1  Bodega    //ID prodcutos          //100-20 80   
//        List<Producto> listaBodega = productoServicio.buscarProducto();
//        listaItemsProductos = new ArrayList<>();
//        //for (Producto producto : listaProducto) {//id prodcuto     //CANTIDAD
//            SelectItem itemBodega = new SelectItem(bodega.getIdBodega(), bodega.getCantidadProducto());
//            SelectItem itemVenta = new SelectItem(detalleFactura.getIdDetalleFactura(), detalleFactura.getCantidad());
//            detalleBodega.setTotal(itemBodega-itemVenta);
//            listaItemsProductos.add(itemVenta);
//       // }
//        
//    }
    
    
    public void guardar(){
        Producto producto = new Producto();
        
    }
    

    public DetalleBodega getDetalleBodega() {
        return detalleBodega;
    }

    public List<DetalleBodega> getListaDetalleBodega() {
        return listaDetalleBodega;
    }

    public void setListaDetalleBodega(List<DetalleBodega> listaDetalleBodega) {
        this.listaDetalleBodega = listaDetalleBodega;
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
