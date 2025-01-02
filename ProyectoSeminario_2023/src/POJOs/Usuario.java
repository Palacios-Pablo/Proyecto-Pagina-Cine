package POJOs;
// Generated 30/10/2023 10:41:16 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Perfil perfil;
     private boolean estado;
     private String nombreUsuario;
     private String contrasena;
     private Set<Compra> comprasForUsuarioModifica = new HashSet<Compra>(0);
     private Set<Compra> comprasForUsuarioIngresa = new HashSet<Compra>(0);
     private Set<Empleado> empleadosForUsuarioIngresa = new HashSet<Empleado>(0);
     private Set<Empleado> empleadosForUsuarioModifica = new HashSet<Empleado>(0);
     private Set<Genero> generosForUsuarioIngresa = new HashSet<Genero>(0);
     private Set<Horario> horariosForUsuarioModifica = new HashSet<Horario>(0);
     private Set<Cliente> clientesForUsuarioIngresa = new HashSet<Cliente>(0);
     private Set<Horario> horariosForUsuarioIngresa = new HashSet<Horario>(0);
     private Set<Boleto> boletosForUsuarioIngresa = new HashSet<Boleto>(0);
     private Set<Cliente> clientesForUsuarioModifica = new HashSet<Cliente>(0);
     private Set<Genero> generosForUsuarioModifica = new HashSet<Genero>(0);
     private Set<Boleto> boletosForUsuarioModifica = new HashSet<Boleto>(0);
     private Set<Clasificacion> clasificacionsForUsuarioIngresa = new HashSet<Clasificacion>(0);
     private Set<Pelicula> peliculasForUsuarioModifica = new HashSet<Pelicula>(0);
     private Set<Pelicula> peliculasForUsuarioIngresa = new HashSet<Pelicula>(0);
     private Set<Clasificacion> clasificacionsForUsuarioModifica = new HashSet<Clasificacion>(0);
     private Set<Categoria> categoriasForUsuarioModifica = new HashSet<Categoria>(0);
     private Set<Categoria> categoriasForUsuarioIngresa = new HashSet<Categoria>(0);
     private Set<Sala> salasForUsuarioIngresa = new HashSet<Sala>(0);
     private Set<Sala> salasForUsuarioModifica = new HashSet<Sala>(0);

    public Usuario() {
    }

	
    public Usuario(boolean estado) {
        this.estado = estado;
    }
    public Usuario(Perfil perfil, boolean estado, String nombreUsuario, String contrasena, Set<Compra> comprasForUsuarioModifica, Set<Compra> comprasForUsuarioIngresa, Set<Empleado> empleadosForUsuarioIngresa, Set<Empleado> empleadosForUsuarioModifica, Set<Genero> generosForUsuarioIngresa, Set<Horario> horariosForUsuarioModifica, Set<Cliente> clientesForUsuarioIngresa, Set<Horario> horariosForUsuarioIngresa, Set<Boleto> boletosForUsuarioIngresa, Set<Cliente> clientesForUsuarioModifica, Set<Genero> generosForUsuarioModifica, Set<Boleto> boletosForUsuarioModifica, Set<Clasificacion> clasificacionsForUsuarioIngresa, Set<Pelicula> peliculasForUsuarioModifica, Set<Pelicula> peliculasForUsuarioIngresa, Set<Clasificacion> clasificacionsForUsuarioModifica, Set<Categoria> categoriasForUsuarioModifica, Set<Categoria> categoriasForUsuarioIngresa, Set<Sala> salasForUsuarioIngresa, Set<Sala> salasForUsuarioModifica) {
       this.perfil = perfil;
       this.estado = estado;
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
       this.comprasForUsuarioModifica = comprasForUsuarioModifica;
       this.comprasForUsuarioIngresa = comprasForUsuarioIngresa;
       this.empleadosForUsuarioIngresa = empleadosForUsuarioIngresa;
       this.empleadosForUsuarioModifica = empleadosForUsuarioModifica;
       this.generosForUsuarioIngresa = generosForUsuarioIngresa;
       this.horariosForUsuarioModifica = horariosForUsuarioModifica;
       this.clientesForUsuarioIngresa = clientesForUsuarioIngresa;
       this.horariosForUsuarioIngresa = horariosForUsuarioIngresa;
       this.boletosForUsuarioIngresa = boletosForUsuarioIngresa;
       this.clientesForUsuarioModifica = clientesForUsuarioModifica;
       this.generosForUsuarioModifica = generosForUsuarioModifica;
       this.boletosForUsuarioModifica = boletosForUsuarioModifica;
       this.clasificacionsForUsuarioIngresa = clasificacionsForUsuarioIngresa;
       this.peliculasForUsuarioModifica = peliculasForUsuarioModifica;
       this.peliculasForUsuarioIngresa = peliculasForUsuarioIngresa;
       this.clasificacionsForUsuarioModifica = clasificacionsForUsuarioModifica;
       this.categoriasForUsuarioModifica = categoriasForUsuarioModifica;
       this.categoriasForUsuarioIngresa = categoriasForUsuarioIngresa;
       this.salasForUsuarioIngresa = salasForUsuarioIngresa;
       this.salasForUsuarioModifica = salasForUsuarioModifica;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Set<Compra> getComprasForUsuarioModifica() {
        return this.comprasForUsuarioModifica;
    }
    
    public void setComprasForUsuarioModifica(Set<Compra> comprasForUsuarioModifica) {
        this.comprasForUsuarioModifica = comprasForUsuarioModifica;
    }
    public Set<Compra> getComprasForUsuarioIngresa() {
        return this.comprasForUsuarioIngresa;
    }
    
    public void setComprasForUsuarioIngresa(Set<Compra> comprasForUsuarioIngresa) {
        this.comprasForUsuarioIngresa = comprasForUsuarioIngresa;
    }
    public Set<Empleado> getEmpleadosForUsuarioIngresa() {
        return this.empleadosForUsuarioIngresa;
    }
    
    public void setEmpleadosForUsuarioIngresa(Set<Empleado> empleadosForUsuarioIngresa) {
        this.empleadosForUsuarioIngresa = empleadosForUsuarioIngresa;
    }
    public Set<Empleado> getEmpleadosForUsuarioModifica() {
        return this.empleadosForUsuarioModifica;
    }
    
    public void setEmpleadosForUsuarioModifica(Set<Empleado> empleadosForUsuarioModifica) {
        this.empleadosForUsuarioModifica = empleadosForUsuarioModifica;
    }
    public Set<Genero> getGenerosForUsuarioIngresa() {
        return this.generosForUsuarioIngresa;
    }
    
    public void setGenerosForUsuarioIngresa(Set<Genero> generosForUsuarioIngresa) {
        this.generosForUsuarioIngresa = generosForUsuarioIngresa;
    }
    public Set<Horario> getHorariosForUsuarioModifica() {
        return this.horariosForUsuarioModifica;
    }
    
    public void setHorariosForUsuarioModifica(Set<Horario> horariosForUsuarioModifica) {
        this.horariosForUsuarioModifica = horariosForUsuarioModifica;
    }
    public Set<Cliente> getClientesForUsuarioIngresa() {
        return this.clientesForUsuarioIngresa;
    }
    
    public void setClientesForUsuarioIngresa(Set<Cliente> clientesForUsuarioIngresa) {
        this.clientesForUsuarioIngresa = clientesForUsuarioIngresa;
    }
    public Set<Horario> getHorariosForUsuarioIngresa() {
        return this.horariosForUsuarioIngresa;
    }
    
    public void setHorariosForUsuarioIngresa(Set<Horario> horariosForUsuarioIngresa) {
        this.horariosForUsuarioIngresa = horariosForUsuarioIngresa;
    }
    public Set<Boleto> getBoletosForUsuarioIngresa() {
        return this.boletosForUsuarioIngresa;
    }
    
    public void setBoletosForUsuarioIngresa(Set<Boleto> boletosForUsuarioIngresa) {
        this.boletosForUsuarioIngresa = boletosForUsuarioIngresa;
    }
    public Set<Cliente> getClientesForUsuarioModifica() {
        return this.clientesForUsuarioModifica;
    }
    
    public void setClientesForUsuarioModifica(Set<Cliente> clientesForUsuarioModifica) {
        this.clientesForUsuarioModifica = clientesForUsuarioModifica;
    }
    public Set<Genero> getGenerosForUsuarioModifica() {
        return this.generosForUsuarioModifica;
    }
    
    public void setGenerosForUsuarioModifica(Set<Genero> generosForUsuarioModifica) {
        this.generosForUsuarioModifica = generosForUsuarioModifica;
    }
    public Set<Boleto> getBoletosForUsuarioModifica() {
        return this.boletosForUsuarioModifica;
    }
    
    public void setBoletosForUsuarioModifica(Set<Boleto> boletosForUsuarioModifica) {
        this.boletosForUsuarioModifica = boletosForUsuarioModifica;
    }
    public Set<Clasificacion> getClasificacionsForUsuarioIngresa() {
        return this.clasificacionsForUsuarioIngresa;
    }
    
    public void setClasificacionsForUsuarioIngresa(Set<Clasificacion> clasificacionsForUsuarioIngresa) {
        this.clasificacionsForUsuarioIngresa = clasificacionsForUsuarioIngresa;
    }
    public Set<Pelicula> getPeliculasForUsuarioModifica() {
        return this.peliculasForUsuarioModifica;
    }
    
    public void setPeliculasForUsuarioModifica(Set<Pelicula> peliculasForUsuarioModifica) {
        this.peliculasForUsuarioModifica = peliculasForUsuarioModifica;
    }
    public Set<Pelicula> getPeliculasForUsuarioIngresa() {
        return this.peliculasForUsuarioIngresa;
    }
    
    public void setPeliculasForUsuarioIngresa(Set<Pelicula> peliculasForUsuarioIngresa) {
        this.peliculasForUsuarioIngresa = peliculasForUsuarioIngresa;
    }
    public Set<Clasificacion> getClasificacionsForUsuarioModifica() {
        return this.clasificacionsForUsuarioModifica;
    }
    
    public void setClasificacionsForUsuarioModifica(Set<Clasificacion> clasificacionsForUsuarioModifica) {
        this.clasificacionsForUsuarioModifica = clasificacionsForUsuarioModifica;
    }
    public Set<Categoria> getCategoriasForUsuarioModifica() {
        return this.categoriasForUsuarioModifica;
    }
    
    public void setCategoriasForUsuarioModifica(Set<Categoria> categoriasForUsuarioModifica) {
        this.categoriasForUsuarioModifica = categoriasForUsuarioModifica;
    }
    public Set<Categoria> getCategoriasForUsuarioIngresa() {
        return this.categoriasForUsuarioIngresa;
    }
    
    public void setCategoriasForUsuarioIngresa(Set<Categoria> categoriasForUsuarioIngresa) {
        this.categoriasForUsuarioIngresa = categoriasForUsuarioIngresa;
    }
    public Set<Sala> getSalasForUsuarioIngresa() {
        return this.salasForUsuarioIngresa;
    }
    
    public void setSalasForUsuarioIngresa(Set<Sala> salasForUsuarioIngresa) {
        this.salasForUsuarioIngresa = salasForUsuarioIngresa;
    }
    public Set<Sala> getSalasForUsuarioModifica() {
        return this.salasForUsuarioModifica;
    }
    
    public void setSalasForUsuarioModifica(Set<Sala> salasForUsuarioModifica) {
        this.salasForUsuarioModifica = salasForUsuarioModifica;
    }




}

