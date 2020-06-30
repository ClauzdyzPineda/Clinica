/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Doctor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saker
 */
@Stateless
public class DoctorFacade extends AbstractFacade<Doctor> implements DoctorFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    private EntityManager em;

    public DoctorFacade() {
        super(Doctor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
