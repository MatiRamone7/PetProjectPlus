package com.utn.models.users.Comodidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.users.Usuario;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comodidad")
@DiscriminatorColumn(name="tipoDeComodidad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RadioDeCercania.class, name = "RadioDeCercania"),
        @JsonSubTypes.Type(value = TienePatio.class, name = "TienePatio")
})
public abstract class Comodidad implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    public abstract Boolean cumpleComodidad(FormularioDarEnAdopcion formularioDarEnAdopcion);

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comodidad() {
    }

    public Comodidad(Usuario usuario) {
        this.usuario = usuario;
    }
}
