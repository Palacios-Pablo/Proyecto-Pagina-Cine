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
public class BeanPelicula {
    
   private String titulo, director;
   private List listaPelicula, listaClasificacion, listaGenero;
   private Date anioLanzamiento;
   private Integer idPelicula, idUsuario, idClasificacion, idGenero;
   private Boolean componentes=false;

   
   @PostConstruct
    public void inicio(){
        llenarComboClasificacion();
        llenarComboGenero();
        mostrarPelicula();
    }
    
    
    public List<SelectItem> llenarComboClasificacion() {
        setListaClasificacion(new ArrayList<SelectItem>());
        List<POJOs.Clasificacion> lstClasificacion = CRUDs.CRUDClasificacion.universo();
        for (POJOs.Clasificacion clasificacion : lstClasificacion) {
            SelectItem clasificacionItem = new SelectItem(clasificacion.getIdClasificacion(), clasificacion.getClasificacion());
            getListaClasificacion().add(clasificacionItem);
        }
        return getListaClasificacion();
    }
    
     public List<SelectItem> llenarComboGenero() {
        setListaGenero(new ArrayList<SelectItem>());
        List<POJOs.Genero> lstGenero = CRUDs.CRUDGenero.universo();
        for (POJOs.Genero genero : lstGenero) {
            SelectItem GeneroItem = new SelectItem(genero.getIdGenero(), genero.getGenero());
            getListaGenero().add(GeneroItem);
        }
        return getListaGenero();
    }
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the listaPelicula
     */
    public List getListaPelicula() {
        return listaPelicula;
    }

    /**
     * @param listaPelicula the listaPelicula to set
     */
    public void setListaPelicula(List listaPelicula) {
        this.listaPelicula = listaPelicula;
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
     * @return the listaGenero
     */
    public List getListaGenero() {
        return listaGenero;
    }

    /**
     * @param listaGenero the listaGenero to set
     */
    public void setListaGenero(List listaGenero) {
        this.listaGenero = listaGenero;
    }

    /**
     * @return the anioLanzamiento
     */
    public Date getAnioLanzamiento() {
        return anioLanzamiento;
    }

    /**
     * @param anioLanzamiento the anioLanzamiento to set
     */
    public void setAnioLanzamiento(Date anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }
    
    
   
    public void mostrar(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        idPelicula = CRUDs.CRUDPelicula.select1(usuario).getIdPelicula();
        if(idPelicula != 0){
        idClasificacion = CRUDs.CRUDPelicula.select1(usuario).getClasificacion().getIdClasificacion();
        idGenero = CRUDs.CRUDPelicula.select1(usuario).getGenero().getIdGenero();
            setComponentes((Boolean) true);
        }else{
            setComponentes((Boolean) false);
        }
    }
    
    public void mostrarPelicula(){
        setListaPelicula(CRUDs.CRUDPelicula.universo());
    }
    
    public void limpiar() {
        setTitulo("");
        setDirector("");
        setAnioLanzamiento(null);
        setIdUsuario(null);
    
    }
    
    public void insertar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDPelicula.insert(titulo, director, anioLanzamiento, idClasificacion, idGenero, 8);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Pelicula Ingresada"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise que la Pelicula no haya sido ingresada antes"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        
       
    }

     public void seleccionarDatos(POJOs.Pelicula pelicula){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            boolean flag = CRUDs.CRUDPelicula.eliminar(pelicula.getIdPelicula());
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
            boolean flag = CRUDs.CRUDPelicula.update(idPelicula, titulo, director, anioLanzamiento, idClasificacion, idGenero, idUsuario);
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
            boolean flag = CRUDs.CRUDPelicula.anular(idPelicula, idUsuario);
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

    /**
     * @return the idPelicula
     */
    public Integer getIdPelicula() {
        return idPelicula;
    }

    /**
     * @param idPelicula the idPelicula to set
     */
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
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

    /**
     * @return the idGenero
     */
    public Integer getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
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
    
    
    
   
}