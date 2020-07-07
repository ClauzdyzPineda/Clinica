
package controller;

import entity.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ControllerSessiones implements Serializable{
    public void verificarSesion(){
        FacesMessage mensa;
        try {            
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(us==null){
            context.getExternalContext().redirect("./../index.xhtml");         
            }
        } catch (Exception e) {            
        }
           
    }
    
}
