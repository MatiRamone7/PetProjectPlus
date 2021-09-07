package com.utn.models.users.Comodidaes;

import com.utn.controllers.APIRestController;
import com.utn.controllers.FormController;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.transithomes.Ubication;
import com.utn.utils.Coordenadas;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@DiscriminatorValue("RadioDeCercanía")
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
}
