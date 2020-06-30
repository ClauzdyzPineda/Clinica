/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.UsuarioFacadeLocal;
import entity.Rol;
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
@Named(value = "controllerUsuario")
@SessionScoped
public class ControllerUsuario implements Serializable {
   @EJB
   private UsuarioFacadeLocal usuarioEJB;
   private Usuario usuario;
   private Rol rol;
   private List<Usuario> lista;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Usuario> getLista() {
        lista= usuarioEJB.findAll();
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    @PostConstruct
    public void init(){
        usuario= new Usuario();
        rol = new Rol();
        lista= usuarioEJB.findAll();
    }
    
    
    public  void create(){
        FacesMessage mensa;
        try {
            usuario.setId_rol(rol);            
            usuarioEJB.create(usuario);       
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }
    }
    
     public  void update(){
        FacesMessage mensa;
        try {
            usuario.setId_rol(rol);            
            usuarioEJB.edit(usuario);       
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificados correctamente");
       init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar los datos");
        }
    }
    
      public  void  find(Usuario us){
        try {
            usuario = usuarioEJB.find(us.getId_user());
            usuarioEJB.find(us.getId_user());
            rol = usuario.getId_rol();
        } catch (Exception e) {
        }
    }
      
     public  void delete(Usuario us){
        FacesMessage mensa;
        try {
            usuarioEJB.delete(us);            
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados con exito");
            init();
        } catch (Exception e) {            
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar los datos");
        }
    }
     
   public void  findAll(){
        try {
        lista= usuarioEJB.findAll();
        } catch (Exception e) {
        }
    }
     
}
