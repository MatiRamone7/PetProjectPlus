package com.utn.models.ongs;

import com.utn.models.forms.Direccion;
import com.utn.models.users.Persona;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Usuario> voluntarios;;

    @OneToOne
    @JoinColumn(name="direccion_id")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name="caracteristicas_foto", referencedColumnName = "id")
    public CharsFoto especificacionesFotos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_adopcion_id", referencedColumnName = "id")
    public Set<PreguntaAdoptante> preguntasIntencionDeAdopcion;



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

    public void agregarVoluntario(Persona persona){}
    public void quitarVoluntario(Persona persona){
        voluntarios.remove(persona);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public CharsFoto getEspecificacionesFotos() { return especificacionesFotos; }
    public void setEspecificacionesFotos(CharsFoto especificacionesFotos) {
        this.especificacionesFotos = especificacionesFotos;
    }
}

