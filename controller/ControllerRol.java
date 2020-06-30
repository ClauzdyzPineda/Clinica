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
    
    
}
