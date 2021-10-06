package com.utn.services;

import com.utn.models.roles.*;
import com.utn.repositories.IRolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de roles.
 *
 * @author Grupo 14
 * @see Rol
 * @see RolRepo
 */
@Service
public class RolService implements IRolService{
    @Autowired
    IRolRepo RolRepo;

    /**
     * Retorna la lista de rol.
     *
     * @return lista de rol
     */
    @Override
    public Iterable<Rol> GetRols() {
        return RolRepo.GetRol();
    }

    /**
     * Busca una rol por Id.
     *
     * @param id rol de user a buscar
     * @return rol existente
     */
    @Override
    public Rol GetRolById(Integer id) {
        return RolRepo.GetRolById(id);
    }

    /**
     * Crea un nuevo rol.
     *
     * @param Rol rol a crear
     * @return nuevo rol
     */
    public Rol CreateRol(Rol c) {
        return RolRepo.CreateRol(c);
    }

    /**
     * Actualiza rol existente.
     *
     * @param Rol rol a actualizar
     * @return rol actualizado
     */
    public Rol UpdateRol(Rol c, Integer id) {
        return RolRepo.UpdateRol(c, id);
    }

    /**
     * Borra rol existente.
     *
     * @param id id de rol a eliminar
     */
    public void DeleteRol(Integer id) {
        RolRepo.DeleteRol(id);
    }

}