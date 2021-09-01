package com.utn.models.mascotas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.utn.models.forms.Foto;
import com.utn.models.users.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="mascota")
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "apodo")
    private String apodo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristica_por_mascota_id", referencedColumnName = "id")
    @NotNull
    private Set<CaracteristicaPet> caracteristicSet = new HashSet<>();

    @Column(name = "descripcion")
    private String descripcionFisica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario dueño;

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate edad;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fotos")
    private List<Foto> fotos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "qr")
    private String qr;

    public enum Especie {
        PERRO,
        GATO
    }

    public enum Sexo {
        MACHO,
        HEMBRA,
    }

    // TODO
    // Generar Qr
}
