package com.utn.services;

import com.utn.models.roles.*;
import com.utn.repositories.IRolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
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
     * Retorna la lista de caract.
     *
     * @return lista de caract
     */
    @Override
    public Iterable<Rol> GetRols() {
        return RolRepo.GetRol();
    }

    /**
     * Busca una caract por Id.
     *
     * @param id caract de user a buscar
     * @return caract existente
     */
    @Override
    public Rol GetRolById(Integer id) {
        return RolRepo.GetRolById(id);
    }

    /**
     * Crea un nuevo caract.
     *
     * @param Rol caract a crear
     * @return nuevo caract
     */
    public Rol CreateRol(Rol c) {
        return RolRepo.CreateRol(c);
    }

    /**
     * Actualiza caract existente.
     *
     * @param Rol caract a actualizar
     * @return caract actualizado
     */
    public Rol UpdateRol(Rol c, Integer id) {
        return RolRepo.UpdateRol(c, id);
    }

    /**
     * Borra caract existente.
     *
     * @param id id de caract a eliminar
     */
    public void DeleteRol(Integer id) {
        RolRepo.DeleteRol(id);
    }

}