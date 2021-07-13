package com.utn.services;

import com.utn.models.AdoptionPublication;
import com.utn.repositories.AdoptionPublicationRepo;
import com.utn.repositories.IAdoptionPublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de publications.
 *
 * @author Grupo 14
 * @see AdoptionPublication
 * @see AdoptionPublicationRepo
 */
@Service
public class AdoptionPublicationService implements IAdoptionPublicationService{
    @Autowired
    IAdoptionPublicationRepo publicationRepo;

    /**
     * Retorna la lista de publications.
     *
     * @return lista de publications
     */
    @Override
    public Iterable<AdoptionPublication> GetAdoptionPublications() {
        return publicationRepo.GetAdoptionPublication();
    }

    /**
     * Busca una publication por Id.
     *
     * @param id id de publication a buscar
     * @return publication existente
     */
    @Override
    public AdoptionPublication GetAdoptionPublicationById(Integer id) {
        return publicationRepo.GetAdoptionPublicationById(id);
    }

    /**
     * Crea una nueva publication.
     *
     * @param publication publication a crear
     * @return nueva publication
     */
    public AdoptionPublication CreateAdoptionPublication(AdoptionPublication publication) {

        return publicationRepo.CreateAdoptionPublication(publication);
    }

    /**
     * Borra publication existente.
     *
     * @param id id de publication a eliminar
     */
    public void DeleteAdoptionPublication(Integer id) {
        publicationRepo.DeleteAdoptionPublication(id);
    }

}
