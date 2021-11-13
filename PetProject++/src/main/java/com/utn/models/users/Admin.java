package com.utn.models.users;

import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.roles.Rol;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
public class Admin extends Persona implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //TODO mirar si esto vuela o no
    public void agregarCaracteristica(CaracteristicaPet caracteristica){

    }
    public void quitarCaracteristica(CaracteristicaPet caractersitica){

    }

}