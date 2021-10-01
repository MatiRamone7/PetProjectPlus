package com.utn.services;

import com.utn.models.roles.*;

public interface IRolService {
    public Iterable<Rol> GetRols();

    public Rol GetRolById(Integer id);

    public Rol CreateRol(Rol rol);

    public Rol UpdateRol(Rol rol, Integer id);

    public void DeleteRol(Integer id);
}
