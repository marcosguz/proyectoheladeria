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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "puesto_trabajo")
@NamedQueries({
    @NamedQuery(name = "PuestoTrabajo.findAll", query = "SELECT p FROM PuestoTrabajo p")})
public class PuestoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puesto_trabajo")
    private Integer idPuestoTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_puesto_trabajo")
    private String nombrePuestoTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_puesto_trabajo")
    private String descripcionPuestoTrabajo;
    @Column(name = "estado_puesto_trabajo")
    private Boolean estadoPuestoTrabajo;
    @OneToMany(mappedBy = "idPuestoTrabajo", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public PuestoTrabajo() {
    }

    public PuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public PuestoTrabajo(Integer idPuestoTrabajo, String nombrePuestoTrabajo, String descripcionPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
    }

    public Integer getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    public String getDescripcionPuestoTrabajo() {
        return descripcionPuestoTrabajo;
    }

    public void setDescripcionPuestoTrabajo(String descripcionPuestoTrabajo) {
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
    }

    public Boolean getEstadoPuestoTrabajo() {
        return estadoPuestoTrabajo;
    }

    public void setEstadoPuestoTrabajo(Boolean estadoPuestoTrabajo) {
        this.estadoPuestoTrabajo = estadoPuestoTrabajo;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuestoTrabajo != null ? idPuestoTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoTrabajo)) {
            return false;
        }
        PuestoTrabajo other = (PuestoTrabajo) object;
        if ((this.idPuestoTrabajo == null && other.idPuestoTrabajo != null) || (this.idPuestoTrabajo != null && !this.idPuestoTrabajo.equals(other.idPuestoTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.PuestoTrabajo[ idPuestoTrabajo=" + idPuestoTrabajo + " ]";
    }
    
}
