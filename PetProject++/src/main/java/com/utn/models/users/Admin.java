package com.utn.models.users;
import com.utn.models.CaracteristicaPet;
import com.utn.models.roles.Rol;
import com.utn.models.Sesion;
import com.utn.models.utilities.TipoDocumento;

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

    public Admin(int id, String apellido, LocalDate fechaNacimiento, String nombre, int nroDocumento, TipoDocumento tipoDocumento, Sesion usuario, Rol rol) {
        super(id, apellido, fechaNacimiento, nombre, nroDocumento, tipoDocumento, usuario);
        this.rol = rol;
        this.logs =  new ArrayList<>();
    }

    public void agregarCaracteristica(CaracteristicaPet caracteristica){
        //patear el comportamiento al metodo del controller que agregue al caracteristica a la tabal en BD
    }

    public void quitarCaracteristica(CaracteristicaPet caractersitica){
        //LO MISMO AQUI
    }



}