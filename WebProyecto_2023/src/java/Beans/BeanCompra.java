/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import POJOs.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Yoel
 */
public class BeanCompra {
    private Integer idCompra, idCliente, idUsuario;
    private BigDecimal totalCompra;
    private List listaCompra, listaCliente;
    private Boolean componentes=false;

    /**
     * @return the idCompra
     */
    public Integer getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the totalCompra
     */
    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    /**
     * @param totalCompra the totalCompra to set
     */
    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    /**
     * @return the listaCompra
     */
    public List getListaCompra() {
        return listaCompra;
    }

    /**
     * @param listaCompra the listaCompra to set
     */
    public void setListaCompra(List listaCompra) {
        this.listaCompra = listaCompra;
    }

    /**
     * @return the listaCliente
     */
    public List getListaCliente() {
        return listaCliente;
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(List listaCliente) {
        this.listaCliente = listaCliente;
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
    
    @PostConstruct
    public void inicio(){
        llenarComboCliente();
        mostrar();
    }
    
    public List<SelectItem> llenarComboCliente() {
        setListaCliente(new ArrayList<SelectItem>());
        List<POJOs.Cliente> lstCliente = CRUDs.CRUDCliente.universo();
        for (POJOs.Cliente cliente : lstCliente) {
            SelectItem clienteItem = new SelectItem(cliente.getIdCliente(), cliente.getNombre() + "" + cliente.getApellido());
            getListaCliente().add(clienteItem);
        }
        return getListaCliente();
    }
    
    public void mostrar(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        idCompra = CRUDs.CRUDCompra.select1(usuario).getIdCompra();
        if(idCompra != 0){
        idCliente = CRUDs.CRUDCompra.select1(usuario).getCliente().getIdCliente();
            setComponentes((Boolean) true);
        }else{
            setComponentes((Boolean) false);
        }
    }
    
    public void mostrarCliente(){
        setListaCompra(CRUDs.CRUDCompra .universo());
    }
    
    public void limpiar() {
        setTotalCompra(null);
        setIdUsuario(null);
    }
    
    public void insertar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            boolean flag = CRUDs.CRUDCompra.insert(idCompra, idCliente, totalCompra, idUsuario);
            if(flag){
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Compra Ingresada"));
                limpiar();
            }else{
                context.addMessage(null, new FacesMessage("Error", "Revise que la Compra no haya sido ingresado antes"));
            }
        }catch(Exception e){
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
        
       
    }

     public void seleccionarDatos(POJOs.Compra compra){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            boolean flag = CRUDs.CRUDCompra.eliminar(compra.getIdCompra());
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
            boolean flag = CRUDs.CRUDCompra.update(idCompra, idCliente, totalCompra, idUsuario);
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
            boolean flag = CRUDs.CRUDCompra.anular(idCompra, idUsuario);
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
