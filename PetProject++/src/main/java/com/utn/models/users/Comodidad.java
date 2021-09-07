package com.utn.models.users;

import com.utn.models.mascotas.CaracteristicaPet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "comodidad")
public class Comodidad implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;


    public Boolean cumpleComodidad(Usuario usuario){
        return true; //TODO :D
    }
    public Boolean cumpleComodidad(Set<CaracteristicaPet> caracteristicaPet){
        return true; //TODO :D
    }
}
