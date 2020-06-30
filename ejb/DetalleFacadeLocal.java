/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Detalle;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface DetalleFacadeLocal {
    void create(Detalle det);
    void edit(Detalle det);
    void delete(Detalle det);
    List<Detalle> findAll();
    Detalle find(Object id);
}
