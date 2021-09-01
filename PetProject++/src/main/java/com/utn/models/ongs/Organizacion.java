package com.utn.models.ongs;

import com.utn.models.forms.Direccion;
import com.utn.models.users.Persona;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="ong")
public class Organizacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @OneToOne
    @JoinColumn(name="direccion")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name="caracteristicas_foto", referencedColumnName = "id")
    public CharsFoto especificacionesFotos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_adopcion_id", referencedColumnName = "id")
    public Set<PreguntaAdoptante> preguntasIntencionDeAdopcion;

    public Set<Persona> voluntarios;;



    public void agregarPreguntaAdopcion(String pregunta){
        PreguntaAdoptante nPregunta = new PreguntaAdoptante();
        nPregunta.setPregunta(pregunta);
        preguntasIntencionDeAdopcion.add(nPregunta);
    }

    public void agregarVoluntario(Persona persona){}

    public void quitarPreguntaAdopcion(String pregunta){
        for (PreguntaAdoptante unaPregunta : preguntasIntencionDeAdopcion){
            if (unaPregunta.getPregunta().equals(pregunta)){
                preguntasIntencionDeAdopcion.remove(unaPregunta);
            }
        }
    }

    public void quitarVoluntario(Persona persona){
        voluntarios.remove(persona);
    }
}
