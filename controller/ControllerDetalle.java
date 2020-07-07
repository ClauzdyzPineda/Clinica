/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.DetalleFacadeLocal;
import entity.Cita;
import entity.Detalle;
import entity.Estado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controllerDetalle")
@SessionScoped
public class ControllerDetalle implements Serializable {

    @EJB
    private DetalleFacadeLocal detalleEJB;
    private Detalle detalle;
    private Cita cita;
    private Estado estado;
    private List<Detalle> lista;
    private String mensaje;

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

    public List<Detalle> getLista() {
        lista = detalleEJB.findAll();
        return lista;
    }

    public void setLista(List<Detalle> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.detalle = new Detalle();
        lista = detalleEJB.findAll();
        this.cita = new Cita();
        this.estado = new Estado();
    }

    public void create() {
        try {
            detalle.setId_cita(cita);
            detalle.setId_estado(estado);
            detalleEJB.create(detalle);
            mensaje = "Datos guardados correctamente";
            detalle = new Detalle();
            cita = new Cita();
            estado = new Estado();
        } catch (Exception e) {
            mensaje = "Error al guardar" + e.getMessage();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void controlAll() {
        try {
            lista = detalleEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void delete(Detalle dt) {
        try {
            detalleEJB.delete(dt);
            mensaje = "Datos Eliminados correctamente";
        } catch (Exception e) {
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void update() {
        try {
            detalle.setId_cita(cita);
            detalle.setId_estado(estado);
            detalleEJB.edit(detalle);
            mensaje = "Datos Actualizados";
            detalle = new Detalle();
            estado = new Estado();
            cita = new Cita();
        } catch (Exception e) {
        }

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void leerId(Detalle dt) {
        try {
           cita.setId_cita(dt.getId_cita().getId_cita());
           estado.setId_estado(dt.getId_estado().getId_estado());
           detalle.setId_cita(cita);
           detalle.setId_estado(estado);
           detalle = dt;
        } catch (Exception e) {
        }
    }
}
