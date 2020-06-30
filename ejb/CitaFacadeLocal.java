/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Cita;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface CitaFacadeLocal {
    void create(Cita cita);
    void edit(Cita cita);
    void delete(Cita cita);
    List<Cita> findAll();
    Cita find(Object id);
}
