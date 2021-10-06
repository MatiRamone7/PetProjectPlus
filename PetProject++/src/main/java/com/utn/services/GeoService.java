package com.utn.services;

import com.utn.models.forms.Ciudad;
import com.utn.models.forms.Provincia;
import com.utn.repositories.IGeoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de rol.
 *
 * @author Grupo 14
 * @see Ciudad
 * @see GeoRepo
 */
@Service
public class GeoService implements IGeoService{
    @Autowired
    IGeoRepo GeoRepo;

    
    /**
     * Busca una lugar por Id.
     *
     * @param id lugar de user a buscar
     * @return lugar existente
     */
    @Override
    public Ciudad GetCiudadById(Integer id) {
        return GeoRepo.GetCiudadById(id);
    }

    /**
     * Crea un nuevo lugar.
     *
     * @param Ciudad lugar a crear
     * @return nuevo lugar
     */
    public Ciudad CreateCiudad(Ciudad c) {
        return GeoRepo.CreateCiudad(c);
    }

    /**
     * Actualiza lugar existente.
     *
     * @param Ciudad lugar a actualizar
     * @return lugar actualizado
     */
    public Ciudad UpdateCiudad(Ciudad c, Integer id) {
        return GeoRepo.UpdateCiudad(c, id);
    }

    /**
     * Borra lugar existente.
     *
     * @param id id de lugar a eliminar
     */
    public void DeleteCiudad(Integer id) {
        GeoRepo.DeleteCiudad(id);
    }





    

    /**
     * Busca una lugar por Id.
     *
     * @param id lugar de user a buscar
     * @return lugar existente
     */
    @Override
    public Provincia GetProvinciaById(Integer id) {
        return GeoRepo.GetProvinciaById(id);
    }

    /**
     * Crea un nuevo lugar.
     *
     * @param Provincia lugar a crear
     * @return nuevo lugar
     */
    public Provincia CreateProvincia(Provincia c) {
        return GeoRepo.CreateProvincia(c);
    }

    /**
     * Actualiza lugar existente.
     *
     * @param Provincia lugar a actualizar
     * @return lugar actualizado
     */
    public Provincia UpdateProvincia(Provincia c, Integer id) {
        return GeoRepo.UpdateProvincia(c, id);
    }

    /**
     * Borra lugar existente.
     *
     * @param id id de lugar a eliminar
     */
    public void DeleteProvincia(Integer id) {
        GeoRepo.DeleteProvincia(id);
    }
}
