package com.utn.repositories;

import com.utn.models.roles.*;

public interface IRolRepo {
    /*
        Rol
    */

    public Iterable<Rol> GetRol();

    public Rol GetRolById(Integer id);

    public Rol CreateRol(Rol form);

    public Rol UpdateRol(Rol form, Integer id);

    public void DeleteRol(Integer id);

}
