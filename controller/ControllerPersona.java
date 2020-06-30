/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.PersonaFacadeLocal;
import entity.Persona;
import entity.Usuario;
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
@Named(value = "controllerPersona")
@SessionScoped
public class ControllerPersona implements Serializable {
    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    private Usuario usuario;
    private List<Persona> lista;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Persona> getLista() {
        lista = personaEJB.findAll();
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
       usuario = new Usuario();
       persona = new Persona();
       lista = personaEJB.findAll();
    }
    
     public  void create(){
         FacesMessage mensa;
        try {
            persona.setId_user(usuario);
            personaEJB.create(persona);            
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }
    }
    
     public  void update(){
        FacesMessage mensa;
        try {
            persona.setId_user(usuario);
            personaEJB.edit(persona);        
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar los datos");
        }
    }
    
      public  void  find(Persona per){
        try {
            persona = personaEJB.find(per.getId_persona());
            personaEJB.find(per.getId_persona());
            usuario = persona.getId_user();            
        } catch (Exception e) {
        }
    }
      
     public  void delete(Persona per){
        FacesMessage mensa;
        try {
            personaEJB.delete(per);           
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados con exito");
            init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar los datos");
        }
    }
     
   public void  findAll(){
        try {
        lista = personaEJB.findAll();
        } catch (Exception e) {
        }
    }
}
