/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "detalle_bodega")
@NamedQueries({
    @NamedQuery(name = "DetalleBodega.findAll", query = "SELECT d FROM DetalleBodega d")})
public class DetalleBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_bodega")
    private Integer idDetalleBodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_producto")
    @Temporal(TemporalType.DATE)
    private Date fechaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_porducto_bodega")
    private int cantidadPorductoBodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto_venta")
    private int cantidadProductoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bodega idBodega;
    @JoinColumn(name = "id_detalle_factura", referencedColumnName = "id_detalle_factura")
    @ManyToOne(fetch = FetchType.LAZY)
    private DetalleFactura idDetalleFactura;

    public DetalleBodega() {
    }

    public DetalleBodega(Integer idDetalleBodega) {
        this.idDetalleBodega = idDetalleBodega;
    }

    public DetalleBodega(Integer idDetalleBodega, Date fechaProducto, String nombre, int cantidadPorductoBodega, int cantidadProductoVenta, int total) {
        this.idDetalleBodega = idDetalleBodega;
        this.fechaProducto = fechaProducto;
        this.nombre = nombre;
        this.cantidadPorductoBodega = cantidadPorductoBodega;
        this.cantidadProductoVenta = cantidadProductoVenta;
        this.total = total;
    }

    public Integer getIdDetalleBodega() {
        return idDetalleBodega;
    }

    public void setIdDetalleBodega(Integer idDetalleBodega) {
        this.idDetalleBodega = idDetalleBodega;
    }

    public Date getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(Date fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPorductoBodega() {
        return cantidadPorductoBodega;
    }

    public void setCantidadPorductoBodega(int cantidadPorductoBodega) {
        this.cantidadPorductoBodega = cantidadPorductoBodega;
    }

    public int getCantidadProductoVenta() {
        return cantidadProductoVenta;
    }

    public void setCantidadProductoVenta(int cantidadProductoVenta) {
        this.cantidadProductoVenta = cantidadProductoVenta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    public DetalleFactura getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(DetalleFactura idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleBodega != null ? idDetalleBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleBodega)) {
            return false;
        }
        DetalleBodega other = (DetalleBodega) object;
        if ((this.idDetalleBodega == null && other.idDetalleBodega != null) || (this.idDetalleBodega != null && !this.idDetalleBodega.equals(other.idDetalleBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.DetalleBodega[ idDetalleBodega=" + idDetalleBodega + " ]";
    }
    
}
