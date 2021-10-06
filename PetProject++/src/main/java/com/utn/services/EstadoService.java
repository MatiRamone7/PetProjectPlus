package com.utn.services;

import com.utn.models.forms.Estado;
import com.utn.repositories.IEstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de Estado.
 *
 * @author Grupo 14
 * @see Estado
 * @see EstadoRepo
 */
@Service
public class EstadoService implements IEstadoService{
    @Autowired
    IEstadoRepo EstadoRepo;

    /**
     * Retorna la lista de estado.
     *
     * @return lista de estado
     */
    @Override
    public Iterable<Estado> GetEstados() {
        return EstadoRepo.GetEstados();
    }

    /**
     * Busca una estado por Id.
     *
     * @param id estado de user a buscar
     * @return estado existente
     */
    @Override
    public Estado GetEstadoById(Integer id) {
        return EstadoRepo.GetEstadoById(id);
    }

    /**
     * Crea un nuevo estado.
     *
     * @param Estado estado a crear
     * @return nuevo estado
     */
    public Estado CreateEstado(Estado c) {
        return EstadoRepo.CreateEstado(c);
    }

    /**
     * Actualiza estado existente.
     *
     * @param Estado estado a actualizar
     * @return estado actualizado
     */
    public Estado UpdateEstado(Estado c, Integer id) {
        return EstadoRepo.UpdateEstado(c, id);
    }

    /**
     * Borra estado existente.
     *
     * @param id id de estado a eliminar
     */
    public void DeleteEstado(Integer id) {
        EstadoRepo.DeleteEstado(id);
    }

}
