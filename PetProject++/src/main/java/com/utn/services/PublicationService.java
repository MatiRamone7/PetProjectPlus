package com.utn.services;

import com.utn.models.Publication;
import com.utn.repositories.IPublicationRepo;
import com.utn.repositories.PublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de publications.
 *
 * @author Grupo 14
 * @see Publication
 * @see PublicationRepo
 */
@Service
public class PublicationService implements IPublicationService{
    @Autowired
    IPublicationRepo publicationRepo;

    /**
     * Retorna la lista de publications.
     *
     * @return lista de publications
     */
    @Override
    public Iterable<Publication> GetPublications() {
        return publicationRepo.GetPublications();
    }

    /**
     * Busca una publication por Id.
     *
     * @param id id de publication a buscar
     * @return publication existente
     */
    @Override
    public Publication GetPublicationById(Integer id) {
        return publicationRepo.GetPublicationById(id);
    }

    /**
     * Crea una nueva publication.
     *
     * @param publication publication a crear
     * @return nueva publication
     */
    public Publication CreatePublication(Publication publication) {
        return publicationRepo.CreatePublication(publication);
    }

    /**
     * Actualiza publication existente.
     *
     * @param publication publication a actualizar
     * @return publication actualizado
     */
    public Publication UpdatePublication(Publication publication, Integer id) {
        return publicationRepo.UpdatePublication(publication, id);
    }

    /**
     * Borra publication existente.
     *
     * @param id id de publication a eliminar
     */
    public void DeletePublication(Integer id) {
        publicationRepo.DeletePublication(id);
    }
}
