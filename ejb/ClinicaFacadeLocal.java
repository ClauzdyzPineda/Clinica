/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Clinica;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface ClinicaFacadeLocal {
    void create(Clinica cli);
    void edit(Clinica cli);
    void delete(Clinica cli);
    List<Clinica> findAll();
    Clinica find(Object id);
    
}
