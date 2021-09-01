package com.utn.models;

import java.io.IOException;
import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.models.Componentes.TipoDocumento;
import com.utn.models.users.Usuario;

@Entity
@Table(name="mascotas_encontradas")
public class FormularioMascotaEncontrada{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fechaEncontrada", columnDefinition = "DATE")
    private LocalDate fechaHora;

    @OneToOne
    @JoinColumn(name="caracteristicas_foto", referencedColumnName = "id")
    private FormularioMascotaPerdida formularioMascotaPerdida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    public String apellido(){
        return usuario.getApellido();
    }

    public String nombre(){
        return usuario.getNombre();
    }

    public int nroDocumento(){
        return usuario.getNroDocumento();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public FormularioMascotaPerdida getFormularioMascotaPerdida() {
        return formularioMascotaPerdida;
    }

    public void setFormularioMascotaPerdida(FormularioMascotaPerdida formularioMascotaPerdida) {
        this.formularioMascotaPerdida = formularioMascotaPerdida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDocumento tipoDocumento(){
        return usuario.getTipoDocumento();
    }

    public String usuario(){
        return "Id: " + usuario.getId().toString() + " - Nombre: " + usuario.getNombre() + " " + usuario.getApellido();
    }

    public void contactar(IMensajePredet situacion){
        try {
            usuario.contactar(situacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
