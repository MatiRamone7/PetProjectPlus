package com.utn.models.users;

import com.utn.models.roles.Rol;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
public class Admin extends Persona implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}