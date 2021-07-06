package com.utn.services.ServicesPublication;

import com.utn.models.DarEnAdopcion.PublicationGiveAdoption;


public interface IPublicationServiceGiveAdoption {

    public Iterable<PublicationGiveAdoption> GetPublication();

    public PublicationGiveAdoption GetPublicationById(Integer id);

    //public PublicacionDarEnAdopcion Create (PublicacionDarEnAdopcion publicacion);

    //public PublicacionDarEnAdopcion Update (PublicacionDarEnAdopcion publicacion, Integer id);

    //public void Delete (Integer id);

}
