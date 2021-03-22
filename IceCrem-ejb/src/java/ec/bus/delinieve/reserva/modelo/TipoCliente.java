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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tipo_cliente")
@NamedQueries({
    @NamedQuery(name = "TipoCliente.findAll", query = "SELECT t FROM TipoCliente t")})
public class TipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cliente")
    private Integer idTipoCliente;
    @Size(max = 50)
    @Column(name = "nombre_tipo_cliente")
    private String nombreTipoCliente;
    @OneToMany(mappedBy = "idTipoCliente", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public TipoCliente() {
    }

    public TipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombreTipoCliente() {
        return nombreTipoCliente;
    }

    public void setNombreTipoCliente(String nombreTipoCliente) {
        this.nombreTipoCliente = nombreTipoCliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCliente != null ? idTipoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.idTipoCliente == null && other.idTipoCliente != null) || (this.idTipoCliente != null && !this.idTipoCliente.equals(other.idTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.TipoCliente[ idTipoCliente=" + idTipoCliente + " ]";
    }
    
}
