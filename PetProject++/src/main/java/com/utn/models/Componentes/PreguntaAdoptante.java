package com.utn.models.Componentes;

import javax.persistence.*;
@Entity
@Table(name="preguntas_adopcion")
public class PreguntaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pregunta")
    public String pregunta;

    @Enumerated(EnumType.STRING)
    public TipoPregunta tipoPregunta;

    @Column(name = "id_organizacion") //puede ser esto un many to one?
    public int idOrganzacion;
    
    public void setTipoPregunta(TipoPregunta t) {
        this.tipoPregunta = t;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdOrganizacion(int idOrganzacion) {
        this.idOrganzacion = idOrganzacion;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public int getId() {
        return id;
    }

    public int getIdOrganizacion() {
        return idOrganzacion;
    }
}
