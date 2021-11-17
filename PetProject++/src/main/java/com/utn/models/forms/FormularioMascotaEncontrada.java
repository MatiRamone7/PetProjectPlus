package com.utn.models.forms;

import java.time.LocalDate;
import javax.persistence.*;
import com.utn.models.users.Usuario;

@Entity
@Table(name="formulario_mascotas_encontradas")
public class FormularioMascotaEncontrada{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_encontrada", columnDefinition = "DATE")
    private LocalDate fechaHora;

    @OneToOne
    @JoinColumn(name="formulario_mascota_perdida_id")
    private FormularioMascotaPerdida formularioMascotaPerdida;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

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
}
