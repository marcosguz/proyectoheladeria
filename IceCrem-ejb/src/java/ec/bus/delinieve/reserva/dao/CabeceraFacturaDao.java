/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.CabeceraFactura;
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
public class CabeceraFacturaDao extends GenericoDao<CabeceraFactura> {

    public CabeceraFacturaDao() {
        super(CabeceraFactura.class);
    }
    
    public List<CabeceraFactura> buscarCabeceraFactura(){
        Query query = getEntityManager().createQuery("SELECT cf FROM CabeceraFactura cf");
        List<CabeceraFactura> listaCaberaFacura = query.getResultList();
        return listaCaberaFacura;
    }
    
    public Integer devolverUltimaCabecera(){
        Query query = getEntityManager().createNativeQuery("SELECT c.id_cabecera_feactura FROM cabecera_factura c WHERE c.id_cabecera_feactura=(SELECT MAX(id_cabecera_feactura) FROM cabecera_factura c)");
        Object obj = query.getSingleResult();
        return (Integer) obj;
    }
    
    public CabeceraFactura devolverCabeceraId(Integer idCabecera) {
        TypedQuery<CabeceraFactura> query = getEntityManager().createQuery(
                "SELECT c FROM CabeceraFactura c WHERE c.idCabeceraFeactura =:idCabecera", CabeceraFactura.class);
        CabeceraFactura employee = query.setParameter("idCabecera", idCabecera).getSingleResult();
        return employee;
    }
    
}
