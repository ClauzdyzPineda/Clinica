/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.RolFacadeLocal;
import entity.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Saker
 */
@Named(value = "controllerRol")
@SessionScoped
public class ControllerRol implements Serializable {
    @EJB
    private RolFacadeLocal rolEJB;
    private Rol rol;
    private List<Rol> lista;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getLista() {
        lista = rolEJB.findAll();
        return lista;
    }

    public void setLista(List<Rol> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
   public void init(){
       rol = new Rol();
   }
   
   public  void create(){
        FacesMessage mensa;
        try {            
            rolEJB.create(rol);             
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }
   
    public  void update(){
        FacesMessage mensa;
        try {            
            rolEJB.edit(rol);             
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificadps correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }

      public  void  find(Rol r){
        try {
            rol = rolEJB.find(r.getId_rol());
            rolEJB.find(r.getId_rol());
        } catch (Exception e) {
        }
    }
      
     public  void delete(Rol r){
        FacesMessage mensa;
        try {
            rolEJB.delete(r);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados con exito");
            init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }
     
   public void  findAll(){
        try {
        lista = rolEJB.findAll();
        } catch (Exception e) {
        }
    }
    
}
