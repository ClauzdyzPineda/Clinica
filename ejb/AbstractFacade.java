/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Saker
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    protected abstract EntityManager getEntityManager();
    public AbstractFacade(Class<T> entityClass){
       this.entityClass = entityClass;
    }
    
    public void create(T entity){
      getEntityManager().persist(entity);
    }
    public List<T> findAll(){
      javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
       cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
      
    public void edit(T entity){
        getEntityManager().merge(entity);
    }
    
    public void delete(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }
}
