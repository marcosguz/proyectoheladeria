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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_factura")
    private Integer idDetalleFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_final")
    private double precioFinal;
    @JoinColumn(name = "id_cabecera_feactura", referencedColumnName = "id_cabecera_feactura")
    @ManyToOne(fetch = FetchType.LAZY)
    private CabeceraFactura idCabeceraFeactura;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @OneToMany(mappedBy = "idDetalleFactura", fetch = FetchType.LAZY)
    private List<DetalleBodega> detalleBodegaList;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public DetalleFactura(Integer idDetalleFactura, int cantidad, double precioFinal) {
        this.idDetalleFactura = idDetalleFactura;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public CabeceraFactura getIdCabeceraFeactura() {
        return idCabeceraFeactura;
    }

    public void setIdCabeceraFeactura(CabeceraFactura idCabeceraFeactura) {
        this.idCabeceraFeactura = idCabeceraFeactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public List<DetalleBodega> getDetalleBodegaList() {
        return detalleBodegaList;
    }

    public void setDetalleBodegaList(List<DetalleBodega> detalleBodegaList) {
        this.detalleBodegaList = detalleBodegaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFactura != null ? idDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalleFactura == null && other.idDetalleFactura != null) || (this.idDetalleFactura != null && !this.idDetalleFactura.equals(other.idDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.DetalleFactura[ idDetalleFactura=" + idDetalleFactura + " ]";
    }
    
}
