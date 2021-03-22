/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "cabecera_factura")
@NamedQueries({
    @NamedQuery(name = "CabeceraFactura.findAll", query = "SELECT c FROM CabeceraFactura c")})
public class CabeceraFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cabecera_feactura")
    private Integer idCabeceraFeactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @OneToMany(mappedBy = "idCabeceraFeactura", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalleFacturaList;

    public CabeceraFactura() {
    }

    public CabeceraFactura(Integer idCabeceraFeactura) {
        this.idCabeceraFeactura = idCabeceraFeactura;
    }

    public Integer getIdCabeceraFeactura() {
        return idCabeceraFeactura;
    }

    public void setIdCabeceraFeactura(Integer idCabeceraFeactura) {
        this.idCabeceraFeactura = idCabeceraFeactura;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCabeceraFeactura != null ? idCabeceraFeactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraFactura)) {
            return false;
        }
        CabeceraFactura other = (CabeceraFactura) object;
        if ((this.idCabeceraFeactura == null && other.idCabeceraFeactura != null) || (this.idCabeceraFeactura != null && !this.idCabeceraFeactura.equals(other.idCabeceraFeactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.CabeceraFactura[ idCabeceraFeactura=" + idCabeceraFeactura + " ]";
    }
    
}
