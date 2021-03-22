/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.CabeceraFactura;
import ec.bus.delinieve.reserva.modelo.Cliente;
import ec.bus.delinieve.reserva.modelo.DetalleFactura;
import ec.bus.delinieve.reserva.modelo.Empleado;
import ec.bus.delinieve.reserva.modelo.Persona;
import ec.bus.delinieve.reserva.modelo.Producto;
import ec.bus.delinieve.reserva.servicio.CabeceraFacturaServicio;
import ec.bus.delinieve.reserva.servicio.ClienteServicio;
import ec.bus.delinieve.reserva.servicio.DetalleFacturaServicio;
import ec.bus.delinieve.reserva.servicio.EmpleadoServicio;
import ec.bus.delinieve.reserva.servicio.PersonaServicio;
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
@Named(value = "detalleFacturaControl")
@ViewScoped
public class DetalleFacturaControl implements Serializable {

    private DetalleFactura detalleFactura;
    private List<DetalleFactura> listaDetalleFactura;

    private CabeceraFactura cabeceraFactura;
    private List<CabeceraFactura> listaCabeceraFactura;

    private List<SelectItem> selectItemProducto;
    private Map<Integer, Producto> mapaProducto;
    private Integer idProducto;

    private List<SelectItem> selectItemEmpleado;
    private Integer idEmpleado;
    private Map<Integer, Empleado> mapaEmpleado;

    private Cliente cliente;
    private List<Cliente> listaCliente;

    private List<DetalleFactura> listaDetalleFacturaTemporal;
    private List<Producto> listaProducto;
    private Integer cantidad;
    
    private Empleado empleado;
    private Persona persona;

    @EJB
    private ProductoServicio productoServicio;
    @EJB
    private CabeceraFacturaServicio cabeceraFacturaServicio;
    @EJB
    private DetalleFacturaServicio detalleFacturaServicio;
    @EJB
    private EmpleadoServicio empleadoServicio;
    @EJB
    private ClienteServicio clienteServicio;
    
    @EJB
    private PersonaServicio personaServicio;

    @PostConstruct
    public void init() {
        listaDetalleFactura = new ArrayList<>();
        listaDetalleFacturaTemporal = new ArrayList<>();
        cabeceraFactura = new CabeceraFactura();
        detalleFactura = new DetalleFactura();
        cliente = new Cliente();
        persona = new Persona();
//        cabeceraFactura.setIdCliente(new Cliente());
        crearSelectItemProducto(buscarProducto());
        crearSelectItemEmpleado(buscarEmpleado());
        buscarDetalleFactura();
        buscarCabeceraFactura();
        buscarCliente();
        listaProducto = buscarProducto();
    }

    public void buscarCabeceraFactura() {
        listaCabeceraFactura = cabeceraFacturaServicio.buscarCabeceraFactura();
    }

    public void buscarDetalleFactura() {
        listaDetalleFactura = detalleFacturaServicio.buscarDetalleFactura();
    }

    public void buscarCliente() {
        listaCliente = clienteServicio.buscarCliente();
    }

    private List<Producto> buscarProducto() {
        List<Producto> listaProducto = productoServicio.buscarProducto();
        mapaProducto = new HashMap<>();
        for (Producto producto : listaProducto) {
            mapaProducto.put(producto.getIdProducto(), producto);
        }
        return listaProducto;
    }

    private void crearSelectItemProducto(List<Producto> listaProducto) {
        selectItemProducto = new ArrayList<>();
        for (Producto producto : listaProducto) {
            SelectItem itemDetalleFactura = new SelectItem(producto.getIdProducto(), producto.getIdBodega().getNombreProducto());
            selectItemProducto.add(itemDetalleFactura);
        }
    }

    private List<Empleado> buscarEmpleado() {
        List<Empleado> listaEmpleado = empleadoServicio.buscarEmpleado();
        mapaEmpleado = new HashMap<>();
        for (Empleado empleado : listaEmpleado) {
            mapaEmpleado.put(empleado.getIdEmpleado(), empleado);
        }
        return listaEmpleado;
    }

    private void crearSelectItemEmpleado(List<Empleado> listaEmpleado) {
        selectItemEmpleado = new ArrayList<>();
        for (Empleado empleado : listaEmpleado) {
            SelectItem itemDetalleFactura1 = new SelectItem(empleado.getIdEmpleado(), empleado.getIdPersona().getApellido() + " " + empleado.getIdPersona().getNombre());
            selectItemEmpleado.add(itemDetalleFactura1);
        }
    }
    
    public double precioFinal(int cantidad, Producto producto){
        return producto.getPrecioUnitario()*cantidad; 
    }

    public void agregarProducto() {
        DetalleFactura detalle = new DetalleFactura();
        Producto producto = mapaProducto.get(idProducto);
        detalle.setIdProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecioFinal(precioFinal(cantidad, producto));
        //        detalleFacturaServicio.guardar(detalleFactura); 
        //        detalle.setIdCabeceraFeactura(cabeceraFactura);
        listaDetalleFacturaTemporal.add(detalle);
        actualizarTotalFactura();
    }
    
    public void actualizarTotalFactura(){
        double subtotal = 0;
        double total = 0;
        double iva = 0;
        for (DetalleFactura detalle : listaDetalleFacturaTemporal) {
            subtotal = subtotal + detalle.getPrecioFinal();
        }
        iva = subtotal * 0.12;
        total = subtotal + iva;
        cabeceraFactura.setSubtotal(subtotal);
        cabeceraFactura.setIva(iva);
        cabeceraFactura.setTotal(total);
    }
    
    

    public void guardar() {
        personaServicio.guardar(persona);
        cliente.setNumeroVisitas(0);
        cliente.setEstadoCliente(true);
        cliente.setIdPersona(personaServicio.devolverPersonaId(personaServicio.devolverUltimoPersona()));
        clienteServicio.guardar(cliente);
        cabeceraFactura.setIdCliente(clienteServicio.devolverClienteId(clienteServicio.devolverUltimoCliente()));
        cabeceraFactura.setIdEmpleado(empleadoServicio.devolverEmpleadoIde(idEmpleado));
        cabeceraFacturaServicio.guardar(cabeceraFactura);
        for (DetalleFactura detalleFactura : listaDetalleFacturaTemporal) {
            detalleFactura.setIdCabeceraFeactura(cabeceraFacturaServicio.devolverCabeceraId(cabeceraFacturaServicio.devolverUltimaCabeceraFactura()));
        }
        detalleFacturaServicio.guardarLista(listaDetalleFacturaTemporal);
        limpiar();
    }

    public void limpiar() {
        cliente = new Cliente();
        this.detalleFactura = new DetalleFactura();
        this.cabeceraFactura = new CabeceraFactura();
        idProducto = null;
        idEmpleado = null;
        this.listaDetalleFactura = new ArrayList<>();
    }

    public void actualizar(DetalleFactura detallefactura) {
        this.detalleFactura = detallefactura;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public CabeceraFactura getCabeceraFactura() {
        return cabeceraFactura;
    }

    public void setCabeceraFactura(CabeceraFactura cabeceraFactura) {
        this.cabeceraFactura = cabeceraFactura;
    }

    public List<SelectItem> getSelectItemProducto() {
        return selectItemProducto;
    }

    public void setSelectItemProducto(List<SelectItem> selectItemProducto) {
        this.selectItemProducto = selectItemProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public List<CabeceraFactura> getListaCabeceraFactura() {
        return listaCabeceraFactura;
    }

    public void setListaCabeceraFactura(List<CabeceraFactura> listaCabeceraFactura) {
        this.listaCabeceraFactura = listaCabeceraFactura;
    }

    public List<SelectItem> getSelectItemEmpleado() {
        return selectItemEmpleado;
    }

    public void setSelectItemEmpleado(List<SelectItem> selectItemEmpleado) {
        this.selectItemEmpleado = selectItemEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<DetalleFactura> getListaDetalleFacturaTemporal() {
        return listaDetalleFacturaTemporal;
    }

    public void setListaDetalleFacturaTemporal(List<DetalleFactura> listaDetalleFacturaTemporal) {
        this.listaDetalleFacturaTemporal = listaDetalleFacturaTemporal;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

}
