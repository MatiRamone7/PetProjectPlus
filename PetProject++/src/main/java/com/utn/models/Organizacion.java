package com.utn.models;

import com.utn.models.Componentes.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="ong")
public class Organizacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name="foto", referencedColumnName = "id")
    private Foto imagen;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<User> voluntarios = new HashSet<>();;

    @OneToOne
    @JoinColumn(name="direccion")
    public Direccion direccion;

    @OneToOne
    @JoinColumn(name="caracteristicas_foto", referencedColumnName = "id")
    public CharsFoto especificacionesFotos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_adopcion_id", referencedColumnName = "id")
    public Set<PreguntaAdoptante> preguntasIntencionDeAdopcion = new HashSet<>();

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

    public Foto getImagen() {
        return imagen;
    }

    public void setImagen(Foto imagen) {
        this.imagen = imagen;
    }

    public void agregarVoluntario(User usuario){
        voluntarios.add(usuario);
    }

    public void quitarVoluntario(User usuario){
        voluntarios.remove(usuario);
    }

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

}
