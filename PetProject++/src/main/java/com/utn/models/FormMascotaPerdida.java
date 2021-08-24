package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.transithomes.Ubication;
import com.utn.models.Componentes.*;
import sun.security.util.BitArray;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormMascotaPerdida extends Form implements Serializable {

    /*
    Datos de Rescatista
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "nroDocumento")
    private int nroDocumento;

    @Column(name = "direccion")
    private Direccion direccion;

    private ContactoUnico contactoUnico;

    /*
    Datos de Mascota
    */
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "patronDistintivo")
    private String patronDistintivo;

    @Column(name = "lugarEncontrado")
    private Ubication lugarEncontrado;

    private List<String> caracteristicasDeLaPublicacionDelHogar;

    private List<BitArray> fotos;

    /*
    Datos de FormMascotaPerdida
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion ong;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();


}
