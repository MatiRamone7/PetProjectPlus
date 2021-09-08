package com.utn.models.ongs;

import javax.persistence.*;
@Entity
@Table(name="preguntas_adopcion")
public class PreguntaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "organizacion_id")
    public Organizacion organizacion;

    @Column(name = "pregunta")
    public String pregunta;

    @Enumerated(EnumType.STRING)
    public TipoPregunta tipoPregunta;


    public PreguntaAdoptante(){}

    public Organizacion getIdOrganizacion() {
        return organizacion;
    }

    public void setIdOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }


}
