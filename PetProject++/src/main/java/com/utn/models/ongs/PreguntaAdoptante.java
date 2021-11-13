package com.utn.models.ongs;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
@Entity
@Table(name="preguntas_adopcion")
public class PreguntaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @JsonBackReference
    public Organizacion organizacion;

    @Column(name = "pregunta")
    public String pregunta;


    @Enumerated(EnumType.STRING)
    public TipoPregunta tipo_pregunta;


    public PreguntaAdoptante(){}

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public TipoPregunta getTipoPregunta() {
        return tipo_pregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipo_pregunta = tipoPregunta;
    }


}
