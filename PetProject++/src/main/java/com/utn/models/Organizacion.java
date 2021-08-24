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

    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "imagenByteArray", column = @Column(name = "imagen")),
        @AttributeOverride( name = "descripcion", column = @Column(name = "descripcion")),
    })
    private Foto imagen;
    
    @OneToMany(mappedBy = "id")
    public Set<User> voluntarios = new HashSet<>();;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "calle", column = @Column(name = "calle")),
        @AttributeOverride( name = "numero", column = @Column(name = "numero")),
        @AttributeOverride( name = "departamento", column = @Column(name = "departamento")),
        @AttributeOverride( name = "codigoPostal", column = @Column(name = "codigoPostal")),
        @AttributeOverride( name = "barrio", column = @Column(name = "barrio")),
        @AttributeOverride( name = "provincia", column = @Column(name = "provincia")),
    })
    public Direccion direccion;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "nivelCalidad", column = @Column(name = "sizeFoto")),
        @AttributeOverride( name = "sizeFoto", column = @Column(name = "tamanio")),
    })
    public CharsFoto especificacionesFotos;

    @Embedded
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
