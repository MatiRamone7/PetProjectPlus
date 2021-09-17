package com.utn.models.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="estadosFormulario")
public class EstadoFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadoID", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado estado;

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate fechaHora;

    @Column(name = "usuario")
    private String usuario;

    public String logEstado(){
        String log = "- EstadoFormID: " + this.id  + '\n'
           + "- Estado: " + this.estado.getNombre() + '\n'
           + "- Fecha: " + this.fechaHora + '\n'
           + "- Usuario: " + this.usuario;

        return log;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setUsuario(Usuario user){
        this.usuario = user.getFullName();
    }

}
