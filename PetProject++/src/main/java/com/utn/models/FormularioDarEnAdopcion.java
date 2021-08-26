package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormularioDarEnAdopcion implements IUserLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private User usuario;

    @Id
    @JoinColumn(name = "petID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Pet mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ong organizacion;

    private List<EstadoFormulario> estado;

    private List<PreguntaRespuestaAdoptante> preguntas;



    /*
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<Characteristic> caracteristicasEspecialesPorONG = new HashSet<>();
    */



    @Override
    public String apellido() {
        return null;
    }

    @Override
    public String nombre() {
        return null;
    }

    @Override
    public int nroDocumento() {
        return 0;
    }

    @Override
    public TipoDocumento tipoDocumento() {
        return null;
    }

    @Override
    public String usuario() {
        return null;
    }
}