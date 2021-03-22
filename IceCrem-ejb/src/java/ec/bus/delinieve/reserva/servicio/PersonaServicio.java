/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.PersonaDao;
import ec.bus.delinieve.reserva.modelo.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marcos
 */
@Stateless
@LocalBean
public class PersonaServicio {

    @EJB
    private PersonaDao personaDao;
    
    public void guardar(Persona persona){
       personaDao.create(persona);
    }
    
    public void guardarLista(List<Persona> listaPersona){
        for (Persona persona : listaPersona) {
            guardar(persona);
        }
    }
    
    public Integer devolverUltimoPersona(){
        return personaDao.devolverUltimoPersona();
    }
    
    public Persona devolverPersonaId(Integer idPersona){
        return personaDao.devolverPersonaId(idPersona);
    }
    
}
