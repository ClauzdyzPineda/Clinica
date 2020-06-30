package controller;

import ejb.DoctorFacadeLocal;
import entity.Doctor;
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

    public void setLista(List<Doctor> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.doctor = new Doctor();
        lista = doctorEJB.findAll();
    }

    public void create() {
        try {
            doctorEJB.create(doctor);
            mensaje = "Datos guardados";
            doctor = new Doctor();
        } catch (Exception e) {
            mensaje = "Error al guardar" + e.getMessage();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
    
     public  void  controlAll(){
        try {
            lista = doctorEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public  void  delete(Doctor p){
        try {
            doctorEJB.delete(p);
            mensaje = "Datos Eliminados";
        } catch (Exception e) {
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
    
    public  void  update(){
        try {
            doctorEJB.edit(doctor);
             mensaje = "Datos Actualizados";
        } catch (Exception e) {
        }
        
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
    
    public  void leerId(Doctor dc){
        try {
            doctor = doctorEJB.find(dc.getId_doctor());
            doctorEJB.find(dc.getId_doctor());
        } catch (Exception e) {
        }
    }

}
