package com.utn.models.forms;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.roles.LogRol;
import com.utn.models.users.Usuario;
import com.utn.models.users.Comodidades.Comodidad;

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

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private Usuario solicitante;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formularioIntencionAdopcionId")
    private List<EstadoFormulario> estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "formularioIntencionDeAdopcionId")
    private Set<CaracteristicaPet> preferencias = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Mascota.Especie especie;

    @Enumerated(EnumType.STRING)
    private Mascota.Sexo sexo;

    public Mascota.Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Mascota.Especie especie) {
        this.especie = especie;
    }

    public Mascota.Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Mascota.Sexo sexo) {
        this.sexo = sexo;
    }

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
