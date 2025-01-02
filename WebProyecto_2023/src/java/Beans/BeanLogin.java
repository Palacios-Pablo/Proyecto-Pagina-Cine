/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Scope.SessionBean;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos-PC
 */
@ManagedBean
@ViewScoped
public class BeanLogin {
    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean=null;
    private String contrasena=null;
    
    @PostConstruct
    public void init(){
        getSessionBean().setUsuario(null);
        getSessionBean().setUsuarioSession(null);
        getSessionBean().setMensaje(null);
    }
    
    public String irPrincipal() throws IOException{
        FacesContext context=FacesContext.getCurrentInstance();
        if(contrasena.equals("") || getSessionBean().getUsuarioSession().equals("")){
            getSessionBean().setMensaje("");
            return null;
        }else{
            POJOs.Usuario usuarioSelect = CRUDs.CRUDUsuario.selectUser(getSessionBean().getUsuarioSession());
            getSessionBean().setUsuario(usuarioSelect);
            String password=CRUDs.CRUDLogin.sha1(contrasena);
            if(usuarioSelect==null){
                getSessionBean().setUsuarioSession("");
                setContrasena("");
                context.addMessage(null, new FacesMessage("Error","El usuario no existe"));
                return "login";
            }else if(usuarioSelect.getContrasena().equals(password)){
                getSessionBean().setUsuarioSession("");
                context.getExternalContext().redirect("index.xhtml");
                context.addMessage(null, new FacesMessage("EXITO","Bienvenido"));
                return null;
            }else{
                setContrasena("");
                getSessionBean().setMensaje("Contraseña incorrecta");
                context.addMessage(null, new FacesMessage("Error","Usuario o Contraseña incorrecta"));
                return "login";
            }  
        }
    }
    
    public void cancelarLogin() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("../WebProyecto_2023");
        setSessionBean(null);
    }

    /**
     * @return the sessionBean
     */
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    /**
     * @param sessionBean the sessionBean to set
     */
    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
