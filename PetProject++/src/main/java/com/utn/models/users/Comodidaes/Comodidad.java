package com.utn.models.users.Comodidaes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Comodidad implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;


    public Boolean cumpleComodidad(FormularioDarEnAdopcion formularioDarEnAdopcion){
        return true; //TODO :D
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
