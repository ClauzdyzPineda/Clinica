/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Rol;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface RolFacadeLocal {
    void create(Rol rol);
    void edit(Rol rol);
    void delete(Rol rol);
    List<Rol> findAll();
    Rol find(Object id);
}
