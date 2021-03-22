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

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario_trabajo")
    @Temporal(TemporalType.DATE)
    private Date horarioTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_empelado")
    private boolean estadoEmpelado;
    @OneToMany(mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    private List<CabeceraFactura> cabeceraFacturaList;
    @OneToMany(mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    private List<Bodega> bodegaList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;
    @JoinColumn(name = "id_puesto_trabajo", referencedColumnName = "id_puesto_trabajo")
    @ManyToOne(fetch = FetchType.LAZY)
    private PuestoTrabajo idPuestoTrabajo;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, Date horarioTrabajo, boolean estadoEmpelado) {
        this.idEmpleado = idEmpleado;
        this.horarioTrabajo = horarioTrabajo;
        this.estadoEmpelado = estadoEmpelado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(Date horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public boolean getEstadoEmpelado() {
        return estadoEmpelado;
    }

    public void setEstadoEmpelado(boolean estadoEmpelado) {
        this.estadoEmpelado = estadoEmpelado;
    }

    public List<CabeceraFactura> getCabeceraFacturaList() {
        return cabeceraFacturaList;
    }

    public void setCabeceraFacturaList(List<CabeceraFactura> cabeceraFacturaList) {
        this.cabeceraFacturaList = cabeceraFacturaList;
    }

    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public PuestoTrabajo getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(PuestoTrabajo idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.bus.delinieve.reserva.modelo.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
