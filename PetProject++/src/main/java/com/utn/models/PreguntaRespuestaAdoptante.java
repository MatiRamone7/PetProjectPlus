package com.utn.models;

import javax.persistence.*;
import com.utn.models.Componentes.PreguntaAdoptante;
@Entity
@Table(name="preguntas_respuesta_adoptante")
public class PreguntaRespuestaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta", referencedColumnName = "id")
    private PreguntaAdoptante pregunta;
    
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
