package com.utn.models.Componentes;

import javax.persistence.Embeddable;

@Embeddable
public class CharsFoto {
    public int nivelCalidad;

    public int sizeFoto;

    public int getSizeFoto() {
        return sizeFoto;
    }

    public void setSizeFoto(int sizeFoto) {
        this.sizeFoto = sizeFoto;
    }

    public int getNivelCalidad() {
        return nivelCalidad;
    }

    public void setNivelCalidad(int NivelCalidad) {
        this.nivelCalidad = NivelCalidad;
    }
}
