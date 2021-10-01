package com.utn.services;

import com.utn.models.users.Comodidaes.RadioDeCercania;
import com.utn.models.users.Comodidaes.TienePatio;
import com.utn.repositories.IComodidadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
 *
 * @author Grupo 14
 * @see Comodidad
 * @see ComodidadRepo
 */
@Service
public class ComodidadesService implements IComodidadesService{
    @Autowired
    IComodidadesRepo ComodidadesRepo;

    /**
     * Retorna la lista de comodidad.
     *
     * @return lista de comodidad
     */
    @Override
    public Iterable<RadioDeCercania> GetRadioDeCercania() {
        return ComodidadesRepo.GetRadioDeCercania();
    }

    /**
     * Busca una comodidad por Id.
     *
     * @param id comodidad de user a buscar
     * @return comodidad existente
     */
    @Override
    public RadioDeCercania GetRadioDeCercaniaById(Integer id) {
        return ComodidadesRepo.GetRadioDeCercaniaById(id);
    }

    /**
     * Crea un nuevo comodidad.
     *
     * @param RadioDeCercania comodidad a crear
     * @return nuevo comodidad
     */
    public RadioDeCercania CreateRadioDeCercania(RadioDeCercania c) {
        return ComodidadesRepo.CreateRadioDeCercania(c);
    }

    /**
     * Actualiza comodidad existente.
     *
     * @param RadioDeCercania comodidad a actualizar
     * @return comodidad actualizado
     */
    public RadioDeCercania UpdateRadioDeCercania(RadioDeCercania c, Integer id) {
        return ComodidadesRepo.UpdateRadioDeCercania(c, id);
    }

    /**
     * Borra comodidad existente.
     *
     * @param id id de comodidad a eliminar
     */
    public void DeleteRadioDeCercania(Integer id) {
        ComodidadesRepo.DeleteRadioDeCercania(id);
    }




    
    /**
     * Retorna la lista de comodidad.
     *
     * @return lista de comodidad
     */
    @Override
    public Iterable<TienePatio> GetTienePatio() {
        return ComodidadesRepo.GetTienePatio();
    }

    /**
     * Busca una comodidad por Id.
     *
     * @param id comodidad de user a buscar
     * @return comodidad existente
     */
    @Override
    public TienePatio GetTienePatioById(Integer id) {
        return ComodidadesRepo.GetTienePatioById(id);
    }

    /**
     * Crea un nuevo comodidad.
     *
     * @param TienePatio comodidad a crear
     * @return nuevo comodidad
     */
    public TienePatio CreateTienePatio(TienePatio c) {
        return ComodidadesRepo.CreateTienePatio(c);
    }

    /**
     * Actualiza comodidad existente.
     *
     * @param TienePatio comodidad a actualizar
     * @return comodidad actualizado
     */
    public TienePatio UpdateTienePatio(TienePatio c, Integer id) {
        return ComodidadesRepo.UpdateTienePatio(c, id);
    }

    /**
     * Borra comodidad existente.
     *
     * @param id id de comodidad a eliminar
     */
    public void DeleteTienePatio(Integer id) {
        ComodidadesRepo.DeleteTienePatio(id);
    }
}

