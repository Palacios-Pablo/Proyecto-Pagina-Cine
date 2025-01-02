package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BeanBoleto {
    private Integer idCompra;
    private Integer idHorario;
    private Integer idSala;
    private Integer numeroAsiento;
    private Integer idUsuario;

    @PostConstruct
    public void init() {
        // Aquí puedes inicializar cualquier dato necesario cuando se crea el bean.
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(Integer numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void insertarBoleto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            boolean flag = CRUDs.CRUDBoleto.insert(idCompra, idHorario, idSala, numeroAsiento, idUsuario);
            if (flag) {
                context.addMessage(null, new FacesMessage("Éxito", "Boleto ingresado"));
                limpiarCampos();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Revise que el boleto no haya sido ingresado antes"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            context.addMessage(null, new FacesMessage("Error", "Error: " + e.getMessage()));
        }
    }

    public void actualizarBoleto() {
        // Implementa la lógica para actualizar un boleto aquí.
    }

    public void anularBoleto() {
        // Implementa la lógica para anular un boleto aquí.
    }

    public void eliminarBoleto() {
        // Implementa la lógica para eliminar un boleto aquí.
    }

    private void limpiarCampos() {
        idCompra = null;
        idHorario = null;
        idSala = null;
        numeroAsiento = null;
        idUsuario = null;
    }
}
