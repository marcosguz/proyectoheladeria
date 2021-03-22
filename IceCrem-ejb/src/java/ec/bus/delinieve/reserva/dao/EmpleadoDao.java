/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcos
 */
@Stateless
public class EmpleadoDao extends GenericoDao<Empleado> {

    public EmpleadoDao() {
        super(Empleado.class);
    }

    public List<Empleado> buscarEmpleado() {
        Query query = getEntityManager().createQuery("SELECT e FROM Empleado e WHERE e.estadoEmpelado=true");
        List<Empleado> listaEmpleado = query.getResultList();
        return listaEmpleado;
    }

    public Empleado devolverEmpleadoId(Integer idEmpleado) {
        TypedQuery<Empleado> query = getEntityManager().createQuery(
                "SELECT e FROM Empleado e WHERE e.estadoEmpelado=true AND e.idEmpleado =:idEmpleado", Empleado.class);
        Empleado employee = query.setParameter("idEmpleado", idEmpleado).getSingleResult();
        return employee;
    }
}
