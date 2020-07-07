package ejb;

import entity.Clinica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClinicaFacade extends AbstractFacade<Clinica> implements ClinicaFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    private EntityManager em;

    public ClinicaFacade() {
        super(Clinica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
}
