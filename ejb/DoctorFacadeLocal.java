/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Doctor;
import java.util.List;

/**
 *
 * @author Saker
 */
public interface DoctorFacadeLocal {
    void create(Doctor doc);
    void edit(Doctor doc);
    void delete(Doctor doc);
    List<Doctor> findAll();
    Doctor find(Object id);
}
