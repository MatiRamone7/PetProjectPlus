package com.utn.models.roles;

import com.utn.models.roles.Permiso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name ="Rol")
public class Rol{

    private String descripcion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //EAGER => los permisos se recuperan al mismo tiempo que el ROL
    private List<Permiso> permisos;


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
}
