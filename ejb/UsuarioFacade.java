/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Saker
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal{
    @PersistenceContext(unitName = "clinica")
    public EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
    @Override
    public int existente(Usuario us){
        int existe =0;
        try {            
            String sql="SELECT us FROM Usuario us WHERE us.usuario=?1 AND us.pass=?2 AND us.estado=?3";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getPass());
            query.setParameter(3, 1);
            us = (Usuario) query.getSingleResult();
            if(us.getId_user()>0){
                existe = us.getId_user();
            }
            return existe;
        } catch (Exception e) {
            System.out.println("Error verificar usuario "+e.getMessage());
           return 0;           
        }        
    }
    
      @Override
    public Usuario consultar(int id){
        Usuario us=null;
        try {
            String sql="SELECT us FROM Usuario us WHERE us.id_user=?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, id);
            us = (Usuario) query.getSingleResult();
        } catch (Exception e) {
             System.out.println("Error verificar usuario "+e.getMessage());
        }
        return us;
    }
    
}
