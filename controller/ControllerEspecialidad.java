/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EspecialidadFacadeLocal;
import entity.Especialidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Saker
 */
@Named(value = "controllerEspecialidad")
@SessionScoped
public class ControllerEspecialidad implements Serializable {

    @EJB
    private EspecialidadFacadeLocal especialidadEJB;
    private Especialidad especialidad;
    private List<Especialidad> lista;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Especialidad> getLista() {
        lista = especialidadEJB.findAll();
        return lista;
    }

    public void setLista(List<Especialidad> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        especialidad = new Especialidad();
        lista = especialidadEJB.findAll();
    }
    
     public  void create(){
         FacesMessage mensa;
        try {
            especialidadEJB.create(especialidad);                
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }
    }
    
     public  void update(){
        FacesMessage mensa;
        try {
           especialidadEJB.edit(especialidad);        
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar los datos");
        }
    }
    
      public  void  find(Especialidad esp){
        try {
            especialidad = especialidadEJB.find(esp.getId_especialidad());            
            especialidadEJB.find(esp.getId_especialidad());            
        } catch (Exception e) {
        }
    }
      
     public  void delete(Especialidad esp){
        FacesMessage mensa;
        try {
            especialidadEJB.delete(esp);                    
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados con exito");
            init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar los datos");
        }
    }
     
   public void  findAll(){
        try {
         lista = especialidadEJB.findAll();
        } catch (Exception e) {
        }
    }
}
