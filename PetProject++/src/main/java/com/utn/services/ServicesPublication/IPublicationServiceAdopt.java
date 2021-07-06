package com.utn.services.ServicesPublication;

import com.utn.models.IntencionAdoptar.PublicationAdopt;

public interface IPublicationServiceAdopt {
    public Iterable<PublicationAdopt> GetPublication();

    public PublicationAdopt GetPublicationById(Integer id);

    //public PublicationAdopt Create (PublicationAdopt publicacion);

    //public PublicationAdopt Update (PublicationAdopt publicacion, Integer id);

    //public void Delete (Integer id);

}
