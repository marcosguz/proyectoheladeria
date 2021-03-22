/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.Persona;
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
public class PersonaDao extends GenericoDao<Persona> {

    public PersonaDao() {
        super(Persona.class);
    }
    
    public Integer devolverUltimoPersona(){
        Query query = getEntityManager().createNativeQuery("SELECT p.id_persona FROM Persona p WHERE p.id_persona=(SELECT MAX(id_persona) FROM Persona p)");
        Object obj = query.getSingleResult();
        return (Integer) obj;
    }
    
    public Persona devolverPersonaId(Integer idPersona) {
        TypedQuery<Persona> query = getEntityManager().createQuery(
                "SELECT p FROM Persona p WHERE p.idPersona =:idPersona", Persona.class);
        Persona employee = query.setParameter("idPersona", idPersona).getSingleResult();
        return employee;
    }
    
}
