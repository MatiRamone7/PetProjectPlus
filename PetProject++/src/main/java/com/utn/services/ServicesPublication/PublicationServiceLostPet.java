package com.utn.services.ServicesPublication;

import com.utn.models.MascotaPerdida.FormLostPet;
import com.utn.models.MascotaPerdida.PublicationLostPet;
import com.utn.repositories.RepositroriesPublication.IFormRepositorieLostPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PublicationServiceLostPet implements IPublicationServiceLostPet {

    @Autowired
    IFormRepositorieLostPet formularioRepositorieMascotaPerdida;


    @Override
    public Iterable<PublicationLostPet> GetPublication() {

        Iterable<PublicationLostPet> forms = StreamSupport.stream(formularioRepositorieMascotaPerdida.GetForms().spliterator(), false).map(f -> DeFormularioAPublicaicon(f)).collect(Collectors.toList());
        return forms;
    }


    @Override
    public PublicationLostPet GetPublicationById(Integer id) {

        FormLostPet unFormulario = formularioRepositorieMascotaPerdida.GetFormsById(id);


        PublicationLostPet unaPublicacion =  DeFormularioAPublicaicon(unFormulario);
        return unaPublicacion;
    }

    public PublicationLostPet DeFormularioAPublicaicon(FormLostPet asdf){
        PublicationLostPet unaPublicacion = new PublicationLostPet();
        return unaPublicacion;//TODO
    }


    /*Create: no ncesario
    Update: no ncesario
    Delete: no ncesario

No se guardan en la DB sino que solo se guardan los formularios

A menos que se ponga que al borrar una publicacion se borre el formulario, CHEQUEAR
    */

}
