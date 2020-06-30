/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Especialidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saker
 */
@Stateless
public class EspecialidadFacade extends AbstractFacade<Especialidad> implements EspecialidadFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    public EntityManager em;

    public EspecialidadFacade() {
        super(Especialidad.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
