/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.math.BigDecimal;
import java.util.Date;
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
public class BeanEmpleado {

    private String nombre, apellidos, cargo;
    private Date fechaInicio;
    private BigDecimal salario;
    private List listaEmpleado;
    private Integer idEmpleado, idUsuario;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

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
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * @return the listaEmpleado
     */
    public List getListaEmpleado() {
        return listaEmpleado;
    }

    /**
     * @param listaEmpleado the listaEmpleado to set
     */
    public void setListaEmpleado(List listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    /**
     * @return the idEmpleado
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @PostConstruct
    public void mostrar() {
        setListaEmpleado(CRUDs.CRUDEmpleado.universo());
    }

    public void limpiar() {
        setNombre("");
        setApellidos("");
        setCargo("");
        setSalario(null);
        setIdUsuario(null);
    }

    public void insertar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            boolean flag = CRUDs.CRUDEmpleado.insert(nombre, apellidos, cargo, salario, 8);
            if (flag) {
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Empleado Ingresado"));
                limpiar();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Revise que el Empleado no haya sido ingresado antes"));
            }
        } catch (Exception e) {
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }

    }

    public void selecionarDatosM(POJOs.Empleado empleado){
        setIdEmpleado(empleado.getIdEmpleado());
        setNombre(empleado.getNombre());
        setApellidos(empleado.getApellido());
        setCargo(empleado.getCargo());
        setSalario(empleado.getSalario());
        setFechaInicio(empleado.getFechaInicioEmpleo());
    }
    
    public void seleccionarDatos(POJOs.Empleado empleado) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            boolean flag = CRUDs.CRUDEmpleado.eliminar(empleado.getIdEmpleado());
            if (flag) {
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro eliminado"));
            } else {
                context.addMessage(null, new FacesMessage("Error", "El registro no se ha elimino"));
            }
        } catch (Exception e) {
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
    }

    public void modificar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            boolean flag = CRUDs.CRUDEmpleado.update(idEmpleado, nombre, apellidos, cargo, salario,  8);
            if (flag) {
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro Modificado"));
                limpiar();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Revise sus datos"));
            }
        } catch (Exception e) {
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
    }

    public void anular() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            boolean flag = CRUDs.CRUDEmpleado.anular(idEmpleado, 8);
            if (flag) {
                mostrar();
                limpiar();
                context.addMessage(null, new FacesMessage("Exito", "Registro Anulado"));

            } else {
                context.addMessage(null, new FacesMessage("Error", "Revise sus datos"));
            }
        } catch (Exception e) {
            System.out.println("Error =" + e);
            context.addMessage(null, new FacesMessage("Error", "Error" + e));
        }
    }

}
