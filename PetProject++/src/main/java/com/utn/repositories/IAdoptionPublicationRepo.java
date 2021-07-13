package com.utn.repositories;

import com.utn.models.AdoptionPublication;
import com.utn.models.Publication;

public interface IAdoptionPublicationRepo {
    public Iterable<AdoptionPublication> GetAdoptionPublication();

    public AdoptionPublication GetAdoptionPublicationById(Integer id);

    public AdoptionPublication CreateAdoptionPublication(AdoptionPublication publication);

    public void DeleteAdoptionPublication(Integer id);
}
