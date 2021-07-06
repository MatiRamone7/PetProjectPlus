package com.utn.services.ServicesPublication;

import com.utn.models.DarEnAdopcion.FormGiveAdoption;
import com.utn.models.DarEnAdopcion.PublicationGiveAdoption;
import com.utn.repositories.RepositroriesPublication.IFormRepositorieGiveAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PublicationServiceGiveAdoption implements IPublicationServiceGiveAdoption {

    @Autowired
    IFormRepositorieGiveAdoption formularioRepositorieDarEnAdopcion;


    @Override
    public Iterable<PublicationGiveAdoption> GetPublication() {

        Iterable<PublicationGiveAdoption> forms = StreamSupport.stream(formularioRepositorieDarEnAdopcion.GetForms().spliterator(), false).map(f -> DeFormularioAPublicaicon(f)).collect(Collectors.toList());
        return forms;
    }


    @Override
    public PublicationGiveAdoption GetPublicationById(Integer id) {

        FormGiveAdoption unFormulario = formularioRepositorieDarEnAdopcion.GetFormsById(id);


        PublicationGiveAdoption unaPublicacion =  DeFormularioAPublicaicon(unFormulario);
        return unaPublicacion;
    }

    public PublicationGiveAdoption DeFormularioAPublicaicon(FormGiveAdoption asdf){
        PublicationGiveAdoption unaPublicacion = new PublicationGiveAdoption();
        return unaPublicacion;//TODO
    }


    /*Create: no ncesario
    Update: no ncesario
    Delete: no ncesario

No se guardan en la DB sino que solo se guardan los formularios

A menos que se ponga que al borrar una publicacion se borre el formulario, CHEQUEAR
    */

}
