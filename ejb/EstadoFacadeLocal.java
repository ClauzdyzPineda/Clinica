/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Estado;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface EstadoFacadeLocal {
    void create(Estado es);
    void edit(Estado es);
    void delete(Estado es);
    List<Estado> findAll();
    Estado find(Object id);
}
