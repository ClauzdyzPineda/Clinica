/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import ejb.DoctorFacadeLocal;
import entity.Doctor;
import entity.Especialidad;
import entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controllerDoctor")
@SessionScoped
public class ControllerDoctor implements Serializable {

    @EJB
    private DoctorFacadeLocal doctorEJB;
    private Doctor doctor;
    private Persona persona;
    private Especialidad especialidad;
    private List<Doctor> lista;
    private String mensaje;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getLista() {
        lista = doctorEJB.findAll();
        return lista;
    }

    public DoctorFacadeLocal getDoctorEJB() {
        return doctorEJB;
    }

    public void setDoctorEJB(DoctorFacadeLocal doctorEJB) {
        this.doctorEJB = doctorEJB;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public void setLista(List<Doctor> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.doctor = new Doctor();
        persona = new Persona();
        especialidad = new Especialidad();
        lista = doctorEJB.findAll();
    }

    public void create() {
       FacesMessage mensa;
        try {
            doctor.setId_especialidad(especialidad);
            doctor.setId_persona(persona);
            doctorEJB.create(doctor);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
            doctor = new Doctor();
            especialidad= new Especialidad();
            persona= new Persona();
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }        
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }
    
     public  void  controlAll(){
        try {
            lista = doctorEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public  void  delete(Doctor p){
         FacesMessage mensa;
        try {
            doctorEJB.delete(p);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados.");
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar");
        }       
        FacesContext.getCurrentInstance().addMessage(null, mensa);
    }
    
    public  void  update(){
        FacesMessage mensa;
        try {
            doctor.setId_especialidad(especialidad);
            doctor.setId_persona(persona);
             doctorEJB.edit(doctor);
             mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificados.");
             doctor = new Doctor();
            especialidad= new Especialidad();
            persona= new Persona();         
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar");
        }
        FacesContext.getCurrentInstance().addMessage(null, mensa);
    }
    
    public  void leerId(Doctor dc){
        try {
            persona.setId_persona(dc.getId_persona().getId_persona());
            especialidad.setId_especialidad(dc.getId_especialidad().getId_especialidad());
            doctor.setId_especialidad(especialidad);
            doctor.setId_persona(persona);
            doctor = dc;                       
        } catch (Exception e) {
        }
    }
    
}
