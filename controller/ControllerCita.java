package controller;

import ejb.CitaFacadeLocal;
import entity.Cita;
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

    @PostConstruct
    public void init() {
        this.cita = new Cita();
        lista = citaEJB.findAll();
    }

    public void create() {
        try {
            citaEJB.create(cita);
            mensaje = "Datos guardados correctamente";
            cita = new Cita();
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
            citaEJB.edit(cita);
            mensaje = "Datos Actualizados";
        } catch (Exception e) {
        }

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void leerId(Cita ct) {
        try {
            cita = citaEJB.find(ct.getId_cita());
            citaEJB.find(ct.getId_cita());
        } catch (Exception e) {
        }
    }

}
