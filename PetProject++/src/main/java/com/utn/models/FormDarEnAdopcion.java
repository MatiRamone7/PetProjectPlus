package com.utn.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class FormDarEnAdopcion extends Form{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User user;

    @Id
    @JoinColumn(name = "petID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Mascota pet;

    /*
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<Characteristic> caracteristicasEspecialesPorONG = new HashSet<>();
    */

    private String[] preguntasGenericas;

    private Organizacion ong;
}