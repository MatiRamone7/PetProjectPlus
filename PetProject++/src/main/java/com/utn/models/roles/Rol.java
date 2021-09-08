package com.utn.models.roles;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name ="rol")
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column
    private String descripcion;

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Permiso> permisos;

    public Rol() { this.permisos = new ArrayList<>(); }

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

    public Integer getId() {
        return id;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}