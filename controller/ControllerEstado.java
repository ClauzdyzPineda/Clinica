package controller;

import ejb.EstadoFacadeLocal;
import entity.Estado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controllerEstado")
@SessionScoped
public class ControllerEstado implements Serializable {

    @EJB
    private EstadoFacadeLocal estadoEJB;
    private Estado estado;
    private List<Estado> lista;
    private String mensaje;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getLista() {
        lista = estadoEJB.findAll();
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;
    }
    
    
    @PostConstruct
    public void init() {
        this.estado = new Estado();
        lista = estadoEJB.findAll();
    }

    public void create() {
        try {
            estadoEJB.create(estado);
            mensaje = "Datos guardados correctamente";
            estado = new Estado();
        } catch (Exception e) {
            mensaje = "Error al guardar" + e.getMessage();
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void controlAll() {
        try {
            lista = estadoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void delete(Estado es) {
        try {
            estadoEJB.delete(es);
            mensaje = "Datos Eliminados correctamente";
        } catch (Exception e) {
        }
        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void update() {
        try {
            estadoEJB.edit(estado);
            mensaje = "Datos Actualizados";
        } catch (Exception e) {
        }

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void leerId(Estado es) {
        try {
            estado = estadoEJB.find(es.getId_estado());
            estadoEJB.find(es.getId_estado());
        } catch (Exception e) {
        }
    }


}
