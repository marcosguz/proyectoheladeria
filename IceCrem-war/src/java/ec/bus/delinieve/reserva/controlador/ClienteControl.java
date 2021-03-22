/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Cliente;
import ec.bus.delinieve.reserva.modelo.Persona;
import ec.bus.delinieve.reserva.modelo.TipoCliente;
import ec.bus.delinieve.reserva.servicio.ClienteServicio;
import ec.bus.delinieve.reserva.servicio.TipoClienteServicio;
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
@Named(value = "clienteControl")
@ViewScoped
public class ClienteControl implements Serializable{

    private Cliente cliente;
    private List<Cliente> listaCliente;
    private List<SelectItem> selectItemTipoCliente;
    private Integer idTipoCliente;
    private Map<Integer, TipoCliente> mapaTipoCliente;

    @EJB
    private TipoClienteServicio tipoClienteServicio;
    
    @EJB
    private ClienteServicio clienteServicio;
    
    @PostConstruct
    public void init(){
        listaCliente = new ArrayList<>();
        cliente = new Cliente();
        cliente.setIdPersona(new Persona());
        crearSelectItemTipoCliente(buscarTipoCliente());
        buscarCliente();
    }
    
    private void buscarCliente(){
        listaCliente = clienteServicio.buscarCliente();
    }
    
    public List<TipoCliente> buscarTipoCliente(){
        List<TipoCliente> listaTipoCliente = tipoClienteServicio.buscarTipoCliente();
        mapaTipoCliente = new HashMap<>();
        for (TipoCliente tipoCliente : listaTipoCliente) {
            mapaTipoCliente.put(tipoCliente.getIdTipoCliente(), tipoCliente);
        }
        return listaTipoCliente;
    }
    
    private void crearSelectItemTipoCliente(List<TipoCliente> listaTipoCliente){
        selectItemTipoCliente = new ArrayList<>();
        for (TipoCliente tipoCliente : listaTipoCliente) {
            SelectItem itemCliente = new SelectItem(tipoCliente.getIdTipoCliente(), tipoCliente.getNombreTipoCliente());
            selectItemTipoCliente.add(itemCliente);
        }
    }
    
    public void guardar(){
        TipoCliente tipoCliente = mapaTipoCliente.get(idTipoCliente);
        cliente.setIdTipoCliente(tipoCliente);
        clienteServicio.guardar(cliente);
        limpiar();
        buscarCliente();
    }
    
    public void limpiar(){
        this.cliente = new Cliente();
        idTipoCliente = null;
    }
    
    public void actualizar(Cliente cliente){
        this.cliente = cliente;
        this.idTipoCliente = cliente.getIdTipoCliente().getIdTipoCliente();
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

    public List<SelectItem> getSelectItemTipoCliente() {
        return selectItemTipoCliente;
    }

    public void setSelectItemTipoCliente(List<SelectItem> selectItemTipoCliente) {
        this.selectItemTipoCliente = selectItemTipoCliente;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
    
    
    
}
