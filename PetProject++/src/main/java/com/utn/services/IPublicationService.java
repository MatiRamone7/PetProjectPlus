package com.utn.services;

public interface IPublicationService {
    public Iterable<Publication> GetPublications();

    public Publication GetPublicationById(Integer id);

    public Publication CreatePublication(Publication publication);

    public Publication UpdatePublication(Publication publication, Integer id);

    public void DeletePublication(Integer id);
}
