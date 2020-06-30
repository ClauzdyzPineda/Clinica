/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Cita;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saker
 */
@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal{
     @PersistenceContext(unitName = "clinica")
    private EntityManager em;

    public CitaFacade() {
        super(Cita.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     
     
}
