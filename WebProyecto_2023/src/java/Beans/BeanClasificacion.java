/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yoel
 */
@ManagedBean
@ViewScoped
public class BeanClasificacion {

  
    private String clasificacion;
    private List listaClasificacion;
    private Integer idClasificacion, idUsuario;
    
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the listaClasificacion
     */
    public List getListaClasificacion() {
        return listaClasificacion;
    }

    /**
     * @param listaClasificacion the listaClasificacion to set
     */
    public void setListaClasificacion(List listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
    }

    /**
     * @return the idClasificacion
     */
    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    /**
     * @param idClasificacion the idClasificacion to set
     */
    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    
    @PostConstruct
    public void mostrar(){
        setListaClasificacion(CRUDs.CRUDClasificacion.universo());
    }
    
    public void limpiar() {
        setClasificacion("");
        setIdUsuario(null);
    }
    
    public void insertar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDClasificacion.insert(clasificacion, 8);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Clasificacion Ingresada"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise que la Clasificacion no haya sido ingresada antes"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        
       
    }

     public void seleccionarDatos(POJOs.Clasificacion clasificacion){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            boolean flag = CRUDs.CRUDClasificacion.eliminar(clasificacion.getIdClasificacion());
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro eliminado"));
            }else{
                context.addMessage(null, new FacesMessage("Error", "El registro no se ha elimino"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        }
     
     public void modificar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDClasificacion.update(idClasificacion, clasificacion, 8);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro Modificado"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise sus datos"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
     }
     
     public void anular(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDClasificacion.anular(idClasificacion, 8);
            if(flag){
                mostrar();
                limpiar();
                context.addMessage(null, new FacesMessage("Exito", "Registro Anulado"));
                
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise sus datos"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
     }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
