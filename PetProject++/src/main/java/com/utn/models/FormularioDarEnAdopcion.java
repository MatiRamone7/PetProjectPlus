package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.Componentes.TipoDocumento;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormularioDarEnAdopcion{
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
    private Mascota mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion organizacion;

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



    public String apellido() {
        return null;
    }

    public String nombre() {
        return null;
    }

    public int nroDocumento() {
        return 0;
    }

    public TipoDocumento tipoDocumento() {
        return null;
    }

    public String usuario() {
        return null;
    }
}