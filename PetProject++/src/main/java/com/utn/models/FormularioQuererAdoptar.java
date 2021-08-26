package com.utn.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormularioQuererAdoptar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User solicitante;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Caracteristica x FormularioAdoptar",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )

    private List<EstadoFormulario> estado;

    private Set<Characteristic> preferencias = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return solicitante;
    }

    public Set<Characteristic> getCaracteristicSet() {
        return preferencias;
    }
}
