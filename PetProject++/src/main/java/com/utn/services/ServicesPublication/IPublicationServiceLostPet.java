package com.utn.services.ServicesPublication;

import com.utn.models.MascotaPerdida.PublicationLostPet;

public interface IPublicationServiceLostPet {
    public Iterable<PublicationLostPet> GetPublication();

    public PublicationLostPet GetPublicationById(Integer id);

    //public PublicationLostPet Create (PublicationLostPet publicacion);

    //public PublicationLostPet Update (PublicationLostPet publicacion, Integer id);

    //public void Delete (Integer id);
}
