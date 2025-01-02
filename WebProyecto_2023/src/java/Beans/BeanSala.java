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
public class BeanSala {
    
    private String nombreSala, tipoSala;
    private List listaSala;
    private Integer idSala, idUsuario, capacidad;

    /**
     * @return the nombreSala
     */
    public String getNombreSala() {
        return nombreSala;
    }

    /**
     * @param nombreSala the nombreSala to set
     */
    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    /**
     * @return the tipoSala
     */
    public String getTipoSala() {
        return tipoSala;
    }

    /**
     * @param tipoSala the tipoSala to set
     */
    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    /**
     * @return the listaSala
     */
    public List getListaSala() {
        return listaSala;
    }

    /**
     * @param listaSala the listaSala to set
     */
    public void setListaSala(List listaSala) {
        this.listaSala = listaSala;
    }

    /**
     * @return the idSala
     */
    public Integer getIdSala() {
        return idSala;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
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

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
    @PostConstruct
    public void mostrar(){
        setListaSala(CRUDs.CRUDSala.universo());
    }
    
    public void limpiar() {
        setNombreSala("");
        setTipoSala("");
        setCapacidad(null);
        setIdUsuario(null);
        
    }
    
    public void insertar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDSala.insert(nombreSala, capacidad, tipoSala, 8);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Sala Ingresada"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise que la Sala no haya sido ingresada antes"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        
       
    }
    
    public void selecionarDatosM(POJOs.Sala sala){
        setIdSala(sala.getIdSala());
        setNombreSala(sala.getNombreSala());
        setCapacidad(sala.getCapacidad());
        setTipoSala(sala.getTipoSala());
    }

     public void seleccionarDatos(POJOs.Sala sala){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            boolean flag = CRUDs.CRUDSala.eliminar(sala.getIdSala());
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
            boolean flag = CRUDs.CRUDSala.update(idSala, nombreSala, capacidad, tipoSala, 8);
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
            boolean flag = CRUDs.CRUDSala.anular(idSala, 8);
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
    
    
    
    
}