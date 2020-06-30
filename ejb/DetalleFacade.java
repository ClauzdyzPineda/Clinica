/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Detalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saker
 */
@Stateless
public class DetalleFacade extends AbstractFacade<Detalle> implements DetalleFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    public EntityManager em;

    public DetalleFacade() {
        super(Detalle.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
