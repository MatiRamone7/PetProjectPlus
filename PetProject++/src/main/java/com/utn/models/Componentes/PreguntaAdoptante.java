package com.utn.models.Componentes;

import javax.persistence.Embeddable;

@Embeddable
public class PreguntaAdoptante {
    public int id;

    public String pregunta;

    public TipoPregunta tipoPregunta;

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
