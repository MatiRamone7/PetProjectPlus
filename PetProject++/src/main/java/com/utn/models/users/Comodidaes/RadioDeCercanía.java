package com.utn.models.users.Comodidaes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.utn.controllers.APIRestController;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.transithomes.Ubication;
import com.utn.utils.Coordenadas;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RadioDeCercanía")
@JsonTypeName("RadioDeCercanía")
public class RadioDeCercanía extends Comodidad{

    @Column(name = "radio")
    private double radio;

    @Override
    public Boolean cumpleComodidad(FormularioDarEnAdopcion formularioDarEnAdopcion){
        Ubication ubicationIntencionAdopcion = APIRestController.getCoordenadasDeEstaDireccion(this.getUsuario().getDireccion());
        Ubication ubicationDarEnAdopcion = APIRestController.getCoordenadasDeEstaDireccion(formularioDarEnAdopcion.getUsuario().getDireccion());

        return Coordenadas.distanciaCoord(  ubicationIntencionAdopcion.getLat(),
                                            ubicationIntencionAdopcion.getLong(),
                                            ubicationDarEnAdopcion.getLat(),
                                            ubicationDarEnAdopcion.getLong()
                                         ) <= radio;

    }

    public RadioDeCercanía() {

    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

}
