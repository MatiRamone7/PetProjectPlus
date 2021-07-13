package com.utn.services;

import com.utn.models.AdoptionPublication;

public interface IAdoptionPublicationService{
    public Iterable<AdoptionPublication> GetAdoptionPublications();

    public AdoptionPublication GetAdoptionPublicationById(Integer id);

    public AdoptionPublication CreateAdoptionPublication (AdoptionPublication publication);

    public void DeleteAdoptionPublication (Integer id);
}
