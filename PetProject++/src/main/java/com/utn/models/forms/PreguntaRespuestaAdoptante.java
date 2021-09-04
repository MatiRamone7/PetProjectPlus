package com.utn.models.forms;

import javax.persistence.*;
import com.utn.models.Componentes.PreguntaAdoptante;
@Entity
@Table(name="preguntaRespuestaAdoptante")
public class PreguntaRespuestaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    private Integer idFormulario;

    private Integer idPregunta;

    @Column(name = "respuesta")
    private String rta;
    
    public Integer getId() {
        return id;
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
