package com.utn.models.users.Comodidaes;

import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.users.Usuario;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Comodidad implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public abstract Boolean cumpleComodidad(FormularioDarEnAdopcion formularioDarEnAdopcion);

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
