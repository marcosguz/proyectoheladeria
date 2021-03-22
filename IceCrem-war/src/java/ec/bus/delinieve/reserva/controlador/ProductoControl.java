/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Bodega;
import ec.bus.delinieve.reserva.modelo.Caracteristica;
import ec.bus.delinieve.reserva.modelo.Producto;
import ec.bus.delinieve.reserva.modelo.TipoProducto;
import ec.bus.delinieve.reserva.servicio.BodegaServicio;
import ec.bus.delinieve.reserva.servicio.CaracteristicaServicio;
import ec.bus.delinieve.reserva.servicio.ProductoServicio;
import ec.bus.delinieve.reserva.servicio.TipoProductoServicio;
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
@Named(value = "productoControl")
@ViewScoped
public class ProductoControl implements Serializable {

    private Producto producto;
    private List<Producto> listaProducto;

    private List<SelectItem> selectItemProductoBodega;
    private Integer idProductoBodega;
    private Map<Integer, Bodega> mapaProductoBodega;

    private List<SelectItem> selectItemTipoProducto;
    private Integer idTipoProducto;
    private Map<Integer, TipoProducto> mapaTipoProducto;

    private List<SelectItem> selectItemCaracteristica;
    private Integer idCaracteristica;
    private Map<Integer, Caracteristica> mapaCaracteristica;

    @EJB
    private BodegaServicio bodegaServicio;

    @EJB
    private TipoProductoServicio tipoProductoServicio;

    @EJB
    private ProductoServicio productoServicio;

    @EJB
    private CaracteristicaServicio caracteristicaServicio;

    @PostConstruct
    public void init() {
        listaProducto = new ArrayList<>();
        producto = new Producto();
        crearSelectItemProductoBodega(buscarProductoBodega());
        crearSelectItemtTipoProducto(buscarTipoProducto());
        crearSelectItemsCaracteristica(buscarCaracteristica());
        buscarProducto();
    }

    private void buscarProducto() {
        listaProducto = productoServicio.buscarProducto();
    }

    public List<Bodega> buscarProductoBodega() {
        List<Bodega> listaProductoBodega = bodegaServicio.buscarBodega();
        mapaProductoBodega = new HashMap<>();
        for (Bodega bodega : listaProductoBodega) {
            mapaProductoBodega.put(bodega.getIdBodega(), bodega);
        }
        return listaProductoBodega;
    }

    public void crearSelectItemProductoBodega(List<Bodega> listaProductoBodega) {
        selectItemProductoBodega = new ArrayList<>();
        for (Bodega bodega : listaProductoBodega) {
            SelectItem itemProducto = new SelectItem(bodega.getIdBodega(), bodega.getNombreProducto());
            selectItemProductoBodega.add(itemProducto);
        }
    }

    public List<TipoProducto> buscarTipoProducto() {
        List<TipoProducto> listaTipoProducto = tipoProductoServicio.buscarTipoProducto();
        mapaTipoProducto = new HashMap<>();
        for (TipoProducto tipoProducto : listaTipoProducto) {
            mapaTipoProducto.put(tipoProducto.getIdTipoProducto(), tipoProducto);
        }
        return listaTipoProducto;
    }

    public void crearSelectItemtTipoProducto(List<TipoProducto> listaTipoProducto) {
        selectItemTipoProducto = new ArrayList<>();
        for (TipoProducto tipoProducto : listaTipoProducto) {
            SelectItem itemProducto = new SelectItem(tipoProducto.getIdTipoProducto(), tipoProducto.getNombreTipoProducto());
            selectItemTipoProducto.add(itemProducto);
        }
    }

    public List<Caracteristica> buscarCaracteristica() {
        List<Caracteristica> listaCaracteristica = caracteristicaServicio.buscarCaracteristica();
        mapaCaracteristica = new HashMap<>();
        for (Caracteristica caracteristica : listaCaracteristica) {
            mapaCaracteristica.put(caracteristica.getIdCaracteristica(), caracteristica);
        }
        return listaCaracteristica;
    }
 
    private void crearSelectItemsCaracteristica(List<Caracteristica> listaCaracteristica) {
        selectItemCaracteristica = new ArrayList<>();
        for (Caracteristica caracteristica : listaCaracteristica) {
            SelectItem itemCaracteristica = new SelectItem(caracteristica.getIdCaracteristica(), caracteristica.getNombreCaracteristica());
            selectItemCaracteristica.add(itemCaracteristica);
        }
    }

    public void guardar() {
        Bodega bodega = mapaProductoBodega.get(idProductoBodega);
        producto.setIdBodega(bodega);
        TipoProducto tipoProducto = mapaTipoProducto.get(idTipoProducto);
        producto.setIdTipoProducto(tipoProducto);
        Caracteristica caracteristica = mapaCaracteristica.get(idCaracteristica);
        producto.setIdCaracteristica(caracteristica);
        productoServicio.guardar(producto);
        limpiar();
        buscarProducto();
    }

    public void limpiar() {
        this.producto = new Producto();
        idProductoBodega = null;
        idTipoProducto = null;
        idCaracteristica = null;
    }

    public void actualizar(Producto producto) {
        this.producto = producto;
        this.idProductoBodega = producto.getIdBodega().getIdBodega();
        this.idTipoProducto = producto.getIdTipoProducto().getIdTipoProducto();
        this.idCaracteristica = producto.getIdCaracteristica().getIdCaracteristica();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<SelectItem> getSelectItemProductoBodega() {
        return selectItemProductoBodega;
    }

    public void setSelectItemProductoBodega(List<SelectItem> selectItemProductoBodega) {
        this.selectItemProductoBodega = selectItemProductoBodega;
    }

    public Integer getIdProductoBodega() {
        return idProductoBodega;
    }

    public void setIdProductoBodega(Integer idProductoBodega) {
        this.idProductoBodega = idProductoBodega;
    }

    public List<SelectItem> getSelectItemTipoProducto() {
        return selectItemTipoProducto;
    }

    public void setSelectItemTipoProducto(List<SelectItem> selectItemTipoProducto) {
        this.selectItemTipoProducto = selectItemTipoProducto;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public List<SelectItem> getSelectItemCaracteristica() {
        return selectItemCaracteristica;
    }

    public void setSelectItemCaracteristica(List<SelectItem> selectItemCaracteristica) {
        this.selectItemCaracteristica = selectItemCaracteristica;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

}
