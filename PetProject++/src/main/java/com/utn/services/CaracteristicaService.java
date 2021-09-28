package com.utn.services;

import com.utn.models.mascotas.Caracteristica;
import com.utn.repositories.ICaracteristicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
 *
 * @author Grupo 14
 * @see Caracteristica
 * @see CaracteristicaRepo
 */
@Service
public class CaracteristicaService implements ICaracteristicaService{
    @Autowired
    ICaracteristicaRepo caracteristicaRepo;

    /**
     * Retorna la lista de caract.
     *
     * @return lista de caract
     */
    @Override
    public Iterable<Caracteristica> GetCaracteristicas() {
        return caracteristicaRepo.GetCaracteristica();
    }

    /**
     * Busca una caract por Id.
     *
     * @param id caract de user a buscar
     * @return caract existente
     */
    @Override
    public Caracteristica GetCaracteristicaById(Integer id) {
        return caracteristicaRepo.GetCaracteristicaById(id);
    }

    /**
     * Crea un nuevo caract.
     *
     * @param caracteristica caract a crear
     * @return nuevo caract
     */
    public Caracteristica CreateCaracteristica(Caracteristica pet) {
        return caracteristicaRepo.CreateCaracteristica(pet);
    }

    /**
     * Actualiza caract existente.
     *
     * @param caracteristica caract a actualizar
     * @return caract actualizado
     */
    public Caracteristica UpdateCaracteristica(Caracteristica pet, Integer id) {
        return caracteristicaRepo.UpdateCaracteristica(pet, id);
    }

    /**
     * Borra caract existente.
     *
     * @param id id de caract a eliminar
     */
    public void DeleteCaracteristica(Integer id) {
        caracteristicaRepo.DeleteCaracteristica(id);
    }

}
