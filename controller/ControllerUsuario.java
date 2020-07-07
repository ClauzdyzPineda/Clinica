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
import javax.faces.context.FacesContext;
import javax.inject.Inject;


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
        lista = usuarioEJB.findAll();
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        rol = new Rol();
        lista = usuarioEJB.findAll();
    }
    //Metodo para verificar si el usuario exite o esta habilitado
    public int iniciarSesion(){
        int estado =0;
        try {
            estado=usuarioEJB.existente(usuario);
        } catch (Exception e) {
            estado =0;
        }
        return estado;
    }
    //Metodo para el inicio se sesion
    public String procesar(){
        int respuesta=0;
        String redireccion=null;
        FacesMessage mensa;  
        Usuario inicio;
        try {            
            respuesta = iniciarSesion();
            if(respuesta==0){
                 mensa = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario desactivado o credenciales incorrectas");
            }else{
                usuario=usuarioEJB.consultar(respuesta);
                rol.setId_rol(usuario.getId_rol().getId_rol());
                usuario.setId_rol(rol);
                inicio= usuario;
                mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Bienvenido ");  
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", inicio);
                if(usuario.getId_rol().getId_rol()==1){
                    redireccion="/view/Administrador.xhtml?faces-redirect=true";
                }
            }            
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
        return redireccion;
    }
    
    
    public void create() {
        FacesMessage mensa;
        try {
            usuario.setId_rol(rol);
            usuarioEJB.create(usuario);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos guardados correctamente");
            usuario = new Usuario();
            rol = new Rol();
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }

    public void update() {
        FacesMessage mensa;
        try {
            usuario.setId_rol(rol);
            usuarioEJB.edit(usuario);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos modificados correctamente");
            usuario = new Usuario();
            rol = new Rol();
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }

    public void find(Usuario us) {
        try {
            rol.setId_rol(us.getId_rol().getId_rol());
            usuario.setId_rol(rol);
            usuario=us;
        } catch (Exception e) {
        }
    }

    public void delete(Usuario us) {
        FacesMessage mensa;
        try {
            usuarioEJB.delete(us);
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", "Datos eliminados con exito");
           usuario = new Usuario();
            rol = new Rol();
        } catch (Exception e) {
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar los datos");
        }
        FacesContext.getCurrentInstance().addMessage(null,mensa);
    }

    public void findAll() {
        try {
            lista = usuarioEJB.findAll();
        } catch (Exception e) {
        }
    }

}
