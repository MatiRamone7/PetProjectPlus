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

    @Column(name = "id_organizacion") //puede ser esto un many to one?
    public int idOrganizacion;

    @Column(name = "pregunta")
    public String pregunta;

    @Enumerated(EnumType.STRING)
    public TipoPregunta tipoPregunta;


    public PreguntaAdoptante(){}

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
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
