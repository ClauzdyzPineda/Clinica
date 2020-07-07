/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.CitaFacadeLocal;
import entity.Cita;
import entity.Doctor;
import entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controllerCita")
@SessionScoped
public class ControllerCita implements Serializable {

    @EJB
    private CitaFacadeLocal citaEJB;
    private Cita cita;
    private Doctor doctor;
    private Persona persona;
    private List<Cita> lista;
    private String mensaje;

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public List<Cita> getLista() {
        lista = citaEJB.findAll();
        return lista;
    }

    public void setLista(List<Cita> lista) {
        this.lista = lista;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @PostConstruct
    public void init() {
        this.cita = new Cita();
        lista = citaEJB.findAll();
        this.doctor = new Doctor();
        this.persona = new Persona();
        
    }

    public void create() {
        try {
            cita.setId_persona(persona);
            cita.setId_doctor(doctor);
            citaEJB.create(cita);
            mensaje = "Datos guardados correctamente";
            cita = new Cita();
            doctor = new Doctor();
            persona = new Persona();
        } catch (Exception e) {
            mensaje = "Error al guardar" + e.getMessage();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void controlAll() {
        try {
            lista = citaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void delete(Cita ct) {
        try {
            citaEJB.delete(ct);
            mensaje = "Datos Eliminados correctamente";
        } catch (Exception e) {
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void update() {
        try {
            cita.setId_persona(persona);
            cita.setId_doctor(doctor);
            citaEJB.edit(cita);
            mensaje = "Datos Actualizados";
            cita = new Cita();
            persona = new Persona();
            doctor = new Doctor();
        } catch (Exception e) {
        } 

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void leerId(Cita ct) {
        try {
            doctor.setId_doctor(ct.getId_doctor().getId_doctor());
            persona.setId_persona(ct.getId_persona().getId_persona());
            cita.setId_persona(persona);
            cita.setId_doctor(doctor);
            cita = ct;
        } catch (Exception e) {
        }
    }

}