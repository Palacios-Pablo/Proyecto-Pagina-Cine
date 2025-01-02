package POJOs;
// Generated 30/10/2023 10:41:16 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pelicula generated by hbm2java
 */
public class Pelicula  implements java.io.Serializable {


     private Integer idPelicula;
     private Clasificacion clasificacion;
     private Genero genero;
     private Usuario usuarioByUsuarioModifica;
     private Usuario usuarioByUsuarioIngresa;
     private boolean estado;
     private String titulo;
     private String director;
     private Date anioLanzamiento;
     private Date fechaIngresa;
     private Date fechaModifica;

    public Pelicula() {
    }

	
    public Pelicula(boolean estado) {
        this.estado = estado;
    }
    public Pelicula(Clasificacion clasificacion, Genero genero, Usuario usuarioByUsuarioModifica, Usuario usuarioByUsuarioIngresa, boolean estado, String titulo, String director, Date anioLanzamiento, Date fechaIngresa, Date fechaModifica) {
       this.clasificacion = clasificacion;
       this.genero = genero;
       this.usuarioByUsuarioModifica = usuarioByUsuarioModifica;
       this.usuarioByUsuarioIngresa = usuarioByUsuarioIngresa;
       this.estado = estado;
       this.titulo = titulo;
       this.director = director;
       this.anioLanzamiento = anioLanzamiento;
       this.fechaIngresa = fechaIngresa;
       this.fechaModifica = fechaModifica;
    }
   
    public Integer getIdPelicula() {
        return this.idPelicula;
    }
    
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }
    public Clasificacion getClasificacion() {
        return this.clasificacion;
    }
    
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Usuario getUsuarioByUsuarioModifica() {
        return this.usuarioByUsuarioModifica;
    }
    
    public void setUsuarioByUsuarioModifica(Usuario usuarioByUsuarioModifica) {
        this.usuarioByUsuarioModifica = usuarioByUsuarioModifica;
    }
    public Usuario getUsuarioByUsuarioIngresa() {
        return this.usuarioByUsuarioIngresa;
    }
    
    public void setUsuarioByUsuarioIngresa(Usuario usuarioByUsuarioIngresa) {
        this.usuarioByUsuarioIngresa = usuarioByUsuarioIngresa;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDirector() {
        return this.director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    public Date getAnioLanzamiento() {
        return this.anioLanzamiento;
    }
    
    public void setAnioLanzamiento(Date anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
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




}

