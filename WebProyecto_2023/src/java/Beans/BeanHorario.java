/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import POJOs.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Yoel
 */
@ManagedBean
@ViewScoped
public class BeanHorario {
    
    
    private Date fechaInicio;
    private Integer idHorario, idUsuario = 8, idSala;
    private List listaHorario, listaSala;
    private Boolean componentes=false;

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the idHorario
     */
    public Integer getIdHorario() {
        return idHorario;
    }

    /**
     * @param idHorario the idHorario to set
     */
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
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
     * @return the listaPelicula
     */
   

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
     * @return the componentes
     */
    public Boolean getComponentes() {
        return componentes;
    }

    /**
     * @param componentes the componentes to set
     */
    public void setComponentes(Boolean componentes) {
        this.componentes = componentes;
    }
    
    /**
     * @return the listaHorario
     */
    public List getListaHorario() {
        return listaHorario;
    }

    /**
     * @param listaHorario the listaHorario to set
     */
    public void setListaHorario(List listaHorario) {
        this.listaHorario = listaHorario;
    }
    
    
    @PostConstruct
    public void inicio(){
        llenarComboSala();
        mostrarHorario();
    }
    
    public List<SelectItem> llenarComboSala() {
        setListaSala(new ArrayList<SelectItem>());
        List<POJOs.Sala> lstSala = CRUDs.CRUDSala.universo();
        for (POJOs.Sala sala : lstSala) {
            SelectItem salaItem = new SelectItem(sala.getIdSala(), sala.getNombreSala());
            getListaSala().add(salaItem);
        }
        return getListaSala();
    }
    
    public void mostrar(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        idHorario = CRUDs.CRUDHorario.select1(usuario).getIdHorario();
        if(idHorario != 0){
        idSala = CRUDs.CRUDHorario.select1(usuario).getSala().getIdSala();
            setComponentes((Boolean) true);
        }else{
            setComponentes((Boolean) false);
        }
    }
    
    public void mostrarHorario(){
        setListaHorario(CRUDs.CRUDHorario.universo());
    }
    
    public void limpiar() {
        setFechaInicio(null);
        setIdUsuario(null);
    }
    
    public void insertar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDHorario.insert(fechaInicio, idSala, 8);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Horario Ingresado"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise que el Horario no haya sido ingresado antes"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        
       
    }

     public void seleccionarDatos(POJOs.Horario horario){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            boolean flag = CRUDs.CRUDHorario.eliminar(horario.getIdHorario());
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
            boolean flag = CRUDs.CRUDHorario.update(idHorario, fechaInicio, idSala, idUsuario);
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
            boolean flag = CRUDs.CRUDHorario.anular(idHorario, idUsuario);
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

    
    
}