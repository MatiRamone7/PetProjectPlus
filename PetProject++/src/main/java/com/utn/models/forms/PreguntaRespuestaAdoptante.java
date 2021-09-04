package com.utn.models.forms;

import javax.persistence.*;

import com.utn.models.ongs.PreguntaAdoptante;

@Entity
@Table(name="preguntaRespuestaAdoptante")
public class PreguntaRespuestaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "formularioID", referencedColumnName = "id")
    private FormularioDarEnAdopcion idFormulario;

    @ManyToOne
    @JoinColumn(name = "preguntaID", referencedColumnName = "id")
    private PreguntaAdoptante idPregunta;

    @Column(name = "respuesta")
    private String rta;
    
    public Integer getId() {
        return id;
    }

    public FormularioDarEnAdopcion getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(FormularioDarEnAdopcion idFormulario) {
        this.idFormulario = idFormulario;
    }

    public PreguntaAdoptante getPregunta() {
        return idPregunta;
    }

    public void setPregunta(PreguntaAdoptante pregunta) {
        this.idPregunta = pregunta;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }
}
