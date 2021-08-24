package com.utn.models;

import javax.persistence.*;

import com.utn.models.Componentes.CaracteristicaPet;

import java.util.HashSet;
import java.util.Set;

public class FormQuererAdoptar extends Form{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User user;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Caracteristica x FormularioAdoptar",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Set<CaracteristicaPet> getCaracteristicSet() {
        return caracteristicSet;
    }
}
