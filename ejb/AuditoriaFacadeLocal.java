/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Auditoria;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface AuditoriaFacadeLocal {
    void create(Auditoria aud);
    void edit(Auditoria aud);
    void delete(Auditoria aud);
    List<Auditoria> findAll();
    Auditoria find(Object id);
}
