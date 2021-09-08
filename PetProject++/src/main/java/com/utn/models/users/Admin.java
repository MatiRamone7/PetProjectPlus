package com.utn.models.users;

import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.roles.Rol;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin extends Persona implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    public void agregarCaracteristica(CaracteristicaPet caracteristica){
        //TODO: patear el comportamiento al metodo del controller que agregue al caracteristica a la tabal en BD
    }
    public void quitarCaracteristica(CaracteristicaPet caractersitica){
        //TODO: LO MISMO AQUI
    }

}