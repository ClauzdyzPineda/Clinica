/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Persona;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface PersonaFacadeLocal {
    void create(Persona per);
    void edit(Persona per);
    void delete(Persona per);
    List<Persona> findAll();
    Persona find(Object id);
}
