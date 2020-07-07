
package ejb;

import entity.Auditoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuditoriaFacade extends AbstractFacade<Auditoria> implements AuditoriaFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    private EntityManager em;

    public AuditoriaFacade() {
        super(Auditoria.class);
    }
        
     @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
}
