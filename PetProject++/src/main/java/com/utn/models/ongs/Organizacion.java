package com.utn.models.ongs;

import com.utn.models.forms.Direccion;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="organizacion")
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    /*
    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Usuario> voluntarios;
    */

    @OneToOne
    @JoinColumn(name="direccion")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name="caracteristicas_foto", referencedColumnName = "id")
    private CharsFoto especificacionesFotos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_adopcion_id", referencedColumnName = "id")
    private Set<PreguntaAdoptante> preguntasIntencionDeAdopcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CharsFoto getEspecificacionesFotos() {
        return especificacionesFotos;
    }

    public void setEspecificacionesFotos(CharsFoto especificacionesFotos) {
        this.especificacionesFotos = especificacionesFotos;
    }

    /*
    public void agregarVoluntario(Usuario usuario){
        voluntarios.add(usuario);
    }

    public void quitarVoluntario(Usuario usuario){
        voluntarios.remove(usuario);
    }
    */

    public void agregarPreguntaAdopcion(String pregunta){
        PreguntaAdoptante nPregunta = new PreguntaAdoptante();
        nPregunta.setPregunta(pregunta);
        preguntasIntencionDeAdopcion.add(nPregunta);
    }

    public void quitarPreguntaAdopcion(String pregunta){
        for (PreguntaAdoptante unaPregunta : preguntasIntencionDeAdopcion){
            if (unaPregunta.getPregunta().equals(pregunta)){
                preguntasIntencionDeAdopcion.remove(unaPregunta);
            }
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<PreguntaAdoptante> getPreguntasIntencionDeAdopcion() {
        return preguntasIntencionDeAdopcion;
    }

    public void setPreguntasIntencionDeAdopcion(Set<PreguntaAdoptante> preguntasIntencionDeAdopcion) {
        this.preguntasIntencionDeAdopcion = preguntasIntencionDeAdopcion;
    }
}
