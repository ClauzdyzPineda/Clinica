
package controller;

import ejb.DetalleFacadeLocal;
import entity.Detalle;
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
   private List<Detalle> lista;
   private String mensaje;

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
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
    }

    public void create() {
        try {
            detalleEJB.create(detalle);
            mensaje = "Datos guardados correctamente";
            detalle = new Detalle();
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
            detalleEJB.edit(detalle);
            mensaje = "Datos Actualizados";
        } catch (Exception e) {
        }

        FacesMessage msj = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public void leerId(Detalle dt) {
        try {
            detalle = detalleEJB.find(dt.getId_detalle());
            detalleEJB.find(dt.getId_detalle());
        } catch (Exception e) {
        }
    }
}
