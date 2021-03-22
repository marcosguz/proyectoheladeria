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
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_producto")
    private boolean estadoProducto;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bodega idBodega;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id_caracteristica")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caracteristica idCaracteristica;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProducto idTipoProducto;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, double precioUnitario, String descripcionProducto, boolean estadoProducto) {
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.descripcionProducto = descripcionProducto;
        this.estadoProducto = estadoProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public boolean getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    public Caracteristica getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Caracteristica idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
