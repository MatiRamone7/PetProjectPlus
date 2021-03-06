package com.utn.models.ongs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utn.models.forms.Direccion;
import com.utn.models.users.Usuario;
import javax.persistence.*;
import java.util.Set;
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

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Usuario> voluntarios;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="direccion")
    private Direccion direccion;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="caracteristicasFoto")
    private CharsFoto especificacionesFotos;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<PreguntaAdoptante> preguntasDarEnAdopcion;

    @Column
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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

    public void agregarVoluntario(Usuario usuario){
        voluntarios.add(usuario);
    }

    public void quitarVoluntario(Usuario usuario){
        voluntarios.remove(usuario);
    }

    public void agregarPreguntaAdopcion(String pregunta){
        PreguntaAdoptante nPregunta = new PreguntaAdoptante();
        nPregunta.setPregunta(pregunta);
        preguntasDarEnAdopcion.add(nPregunta);
    }

    public void quitarPreguntaAdopcion(String pregunta){
        for (PreguntaAdoptante unaPregunta : preguntasDarEnAdopcion){
            if (unaPregunta.getPregunta().equals(pregunta)){
                preguntasDarEnAdopcion.remove(unaPregunta);
            }
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<PreguntaAdoptante> getPreguntasDarEnAdopcion() {
        return preguntasDarEnAdopcion;
    }

    public void setPreguntasDarEnAdopcion(Set<PreguntaAdoptante> preguntasIntencionDeAdopcion) {
        this.preguntasDarEnAdopcion = preguntasIntencionDeAdopcion;
    }

    public Set<Usuario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(Set<Usuario> v) {
        this.voluntarios = v;
    }

}
