package com.utn.models.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.TipoDocumento;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.util.List;

public class FormularioDarEnAdopcion implements IUserLog {

    private List<EstadoFormulario> estado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Id
    @JoinColumn(name = "petID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Mascota mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion organizacion;

    private List<PreguntaRespuestaAdoptante> preguntas;

    @JoinColumn(name = "userID")
    @OneToOne(cascade = { CascadeType.ALL })
    private Usuario usuario;

    /*
    Interface User Log
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

    /*
        actualizarEstado y estadoActual son seter y getter de estado, la primer property
    */
}