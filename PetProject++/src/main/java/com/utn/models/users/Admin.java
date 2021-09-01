package com.utn.models.users;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.roles.Rol;
//import com.utn.models.Sesion;
import com.utn.models.Componentes.TipoDocumento;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.time.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="personaId")
public class Admin extends Persona {

    private List<LocalDate> logs;

    private Rol rol;


    public void agregarCaracteristica(CaracteristicaPet caracteristica){
        //patear el comportamiento al metodo del controller que agregue al caracteristica a la tabal en BD
    }

    /*
        Login y Logout
    */

    public void quitarCaracteristica(CaracteristicaPet caractersitica){
        //LO MISMO AQUI
    }



}