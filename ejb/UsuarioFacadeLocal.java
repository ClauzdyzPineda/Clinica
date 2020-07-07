/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface UsuarioFacadeLocal {
    void create(Usuario us);
    void edit(Usuario us);
    void delete(Usuario us);
    List<Usuario> findAll();
    Usuario find(Object id);
    int existente(Usuario us);
    Usuario consultar(int id);
}
