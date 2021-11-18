package com.utn.models.forms;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utn.models.ongs.PreguntaAdoptante;
@Entity
@Table(name="pregunta_respuesta_adoptante")
public class PreguntaRespuestaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "formulario_dar_en_adopcion_id", referencedColumnName = "id")
    @JsonBackReference
    private FormularioDarEnAdopcion formularioDarEnAdopcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pregunta_id")
    private PreguntaAdoptante pregunta;

    @Column(name = "respuesta")
    private String rta;

    public Integer getId() {
        return id;
    }

    public FormularioDarEnAdopcion getFormularioDarEnAdopcion() {
        return formularioDarEnAdopcion;
    }

    public void setFormularioDarEnAdopcion(FormularioDarEnAdopcion formularioDarEnAdopcion) {
        this.formularioDarEnAdopcion = formularioDarEnAdopcion;
    }

    public PreguntaAdoptante getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaAdoptante pregunta) {
        this.pregunta = pregunta;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }

}
