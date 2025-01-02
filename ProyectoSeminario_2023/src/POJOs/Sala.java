package POJOs;
// Generated 30/10/2023 10:41:16 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sala generated by hbm2java
 */
public class Sala  implements java.io.Serializable {


     private Integer idSala;
     private Usuario usuarioByUsuarioIngresa;
     private Usuario usuarioByUsuarioModifica;
     private boolean estado;
     private String nombreSala;
     private Integer capacidad;
     private String tipoSala;
     private Date fechaIngresa;
     private Date fechaModifica;
     private Set<Boleto> boletos = new HashSet<Boleto>(0);
     private Set<Horario> horarios = new HashSet<Horario>(0);

    public Sala() {
    }

	
    public Sala(boolean estado) {
        this.estado = estado;
    }
    public Sala(Usuario usuarioByUsuarioIngresa, Usuario usuarioByUsuarioModifica, boolean estado, String nombreSala, Integer capacidad, String tipoSala, Date fechaIngresa, Date fechaModifica, Set<Boleto> boletos, Set<Horario> horarios) {
       this.usuarioByUsuarioIngresa = usuarioByUsuarioIngresa;
       this.usuarioByUsuarioModifica = usuarioByUsuarioModifica;
       this.estado = estado;
       this.nombreSala = nombreSala;
       this.capacidad = capacidad;
       this.tipoSala = tipoSala;
       this.fechaIngresa = fechaIngresa;
       this.fechaModifica = fechaModifica;
       this.boletos = boletos;
       this.horarios = horarios;
    }
   
    public Integer getIdSala() {
        return this.idSala;
    }
    
    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
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
    public String getNombreSala() {
        return this.nombreSala;
    }
    
    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }
    public Integer getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public String getTipoSala() {
        return this.tipoSala;
    }
    
    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
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
    public Set<Boleto> getBoletos() {
        return this.boletos;
    }
    
    public void setBoletos(Set<Boleto> boletos) {
        this.boletos = boletos;
    }
    public Set<Horario> getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }




}


