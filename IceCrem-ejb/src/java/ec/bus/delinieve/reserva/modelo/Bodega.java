/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "bodega")
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega")
    private Integer idBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso_producto")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoProducto;
    @OneToMany(mappedBy = "idBodega", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor idProveedor;
    @OneToMany(mappedBy = "idBodega", fetch = FetchType.LAZY)
    private List<DetalleBodega> detalleBodegaList;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodega(Integer idBodega, String nombreProducto, int cantidadProducto, Date fechaIngresoProducto) {
        this.idBodega = idBodega;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaIngresoProducto = fechaIngresoProducto;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Date getFechaIngresoProducto() {
        return fechaIngresoProducto;
    }

    public void setFechaIngresoProducto(Date fechaIngresoProducto) {
        this.fechaIngresoProducto = fechaIngresoProducto;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
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
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
