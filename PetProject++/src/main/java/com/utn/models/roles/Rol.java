package com.utn.models.roles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name ="Rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //EAGER => los permisos se recuperan al mismo tiempo que el ROL
    private List<Permiso> permisos;


    public Rol() {}

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.permisos =  new ArrayList<>();
    }

    public void agregarPermiso(Permiso permiso){
        this.permisos.add(permiso);
    }

    public void quitarPermiso(Permiso permiso){
        int indice = permisos.indexOf(permiso);
        this.permisos.remove(indice);
    }

    public List<Permiso> listarPermisos() {
        return permisos;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
