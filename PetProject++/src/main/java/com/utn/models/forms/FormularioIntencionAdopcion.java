package com.utn.models.forms;

import javax.persistence.*;

import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.users.Usuario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="formularioIntencionDeAdopcion")
public class FormularioIntencionAdopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "userID")
    private Usuario solicitante;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Caracteristica x FormularioAdoptar",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId")})
    private List<EstadoFormulario> estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferencias_usuario", referencedColumnName = "id")
    private Set<CaracteristicaPet> preferencias = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoFormulario> estado) {
        this.estado = estado;
    }

    public Set<CaracteristicaPet> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<CaracteristicaPet> preferencias) {
        this.preferencias = preferencias;
    }

}
