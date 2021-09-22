package com.utn.models.users.Comodidaes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.mascotas.CaracteristicaPet;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("TienePatio")
@JsonTypeName("TienePatio")
public class TienePatio extends Comodidad{
    @Column(name = "patio")
    private boolean patio;

    @Override
    public Boolean cumpleComodidad(FormularioDarEnAdopcion formularioDarEnAdopcion){
        CaracteristicaPet caracteristica = formularioDarEnAdopcion.getMascota().
                getCaracteristicSet().stream().
                filter(caract ->
                        caract.getTipoCaracteristica().getDescripcion() == "Tamanio"
                ).
                findFirst().orElse(null);

        if(caracteristica == null){
            return false;
        }

        String tamanio = caracteristica.getvalor();
        if(tamanio == "Grande" || tamanio == "Mediano") {return this.patio;}

        return true;
    }

    public TienePatio() {
        super();
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }
}
