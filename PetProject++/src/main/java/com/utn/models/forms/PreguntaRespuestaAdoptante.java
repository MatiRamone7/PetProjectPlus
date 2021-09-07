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
    @JoinColumn(name = "formularioID")
    private FormularioDarEnAdopcion formulario;

    @ManyToOne
    @JoinColumn(name = "preguntaID", referencedColumnName = "id")
    private PreguntaAdoptante pregunta;

    @Column(name = "respuesta")
    private String rta;
    
    public Integer getId() {
        return id;
    }

    public FormularioDarEnAdopcion getIdFormulario() {
        return formulario;
    }

    public void setIdFormulario(FormularioDarEnAdopcion formulario) {
        this.formulario = formulario;
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
