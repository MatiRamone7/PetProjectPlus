package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.users.Usuario;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="formularios_dar_en_adopcion")
public class FormularioDarEnAdopcion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "petID")
    private Mascota mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Organizacion organizacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadosDelFormulario", referencedColumnName = "id")
    private List<EstadoFormulario> estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "respuestasAdoptante", referencedColumnName = "id")
    private List<PreguntaRespuestaAdoptante> preguntas;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }


    public List<PreguntaRespuestaAdoptante> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaRespuestaAdoptante> preguntas) {
        this.preguntas = preguntas;
    }

    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoFormulario> estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}