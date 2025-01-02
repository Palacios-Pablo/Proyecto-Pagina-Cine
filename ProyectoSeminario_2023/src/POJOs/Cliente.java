package POJOs;
// Generated 30/10/2023 10:41:16 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private Usuario usuarioByUsuarioIngresa;
     private Usuario usuarioByUsuarioModifica;
     private boolean estado;
     private String nombre;
     private String apellido;
     private String correoElectronico;
     private String telefono;
     private Date fechaIngresa;
     private Date fechaModifica;
     private Set<Compra> compras = new HashSet<Compra>(0);

    public Cliente() {
    }

	
    public Cliente(boolean estado) {
        this.estado = estado;
    }
    public Cliente(Usuario usuarioByUsuarioIngresa, Usuario usuarioByUsuarioModifica, boolean estado, String nombre, String apellido, String correoElectronico, String telefono, Date fechaIngresa, Date fechaModifica, Set<Compra> compras) {
       this.usuarioByUsuarioIngresa = usuarioByUsuarioIngresa;
       this.usuarioByUsuarioModifica = usuarioByUsuarioModifica;
       this.estado = estado;
       this.nombre = nombre;
       this.apellido = apellido;
       this.correoElectronico = correoElectronico;
       this.telefono = telefono;
       this.fechaIngresa = fechaIngresa;
       this.fechaModifica = fechaModifica;
       this.compras = compras;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Usuario getUsuarioByUsuarioIngresa() {
        return this.usuarioByUsuarioIngresa;
    }
    
    public void setUsuarioByUsuarioIngresa(Usuario usuarioByUsuarioIngresa) {
        this.usuarioByUsuarioIngresa = usuarioByUsuarioIngresa;
    }
    public Usuario getUsuarioByUsuarioModifica() {
        return this.usuarioByUsuarioModifica;
    }
    
    public void setUsuarioByUsuarioModifica(Usuario usuarioByUsuarioModifica) {
        this.usuarioByUsuarioModifica = usuarioByUsuarioModifica;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaIngresa() {
        return this.fechaIngresa;
    }
    
    public void setFechaIngresa(Date fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }
    public Date getFechaModifica() {
        return this.fechaModifica;
    }
    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }




}


