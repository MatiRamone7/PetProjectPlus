package com.utn.services.ServicesPublication;


import com.utn.models.IntencionAdoptar.FormAdopt;
import com.utn.models.IntencionAdoptar.PublicationAdopt;
import com.utn.repositories.RepositroriesPublication.IFormRepositorieAdopt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PublicationServiceAdopt implements IPublicationServiceAdopt {
    @Autowired
    IFormRepositorieAdopt formularioRepositorieAdoptar;


    @Override
    public Iterable<PublicationAdopt> GetPublication() {

        Iterable<PublicationAdopt> forms = StreamSupport.stream(formularioRepositorieAdoptar.GetForms().spliterator(), false).map(f -> DeFormularioAPublicaicon(f)).collect(Collectors.toList());
        return forms;
    }


    @Override
    public PublicationAdopt GetPublicationById(Integer id) {

        FormAdopt unFormulario = formularioRepositorieAdoptar.GetFormsById(id);


        PublicationAdopt unaPublicacion =  DeFormularioAPublicaicon(unFormulario);
        return unaPublicacion;
    }

    public PublicationAdopt DeFormularioAPublicaicon(FormAdopt asdf){
        PublicationAdopt unaPublicacion = new PublicationAdopt();
        return unaPublicacion;//TODO
    }


    /*Create: no ncesario
    Update: no ncesario
    Delete: no ncesario

No se guardan en la DB sino que solo se guardan los formularios

A menos que se ponga que al borrar una publicacion se borre el formulario, CHEQUEAR
    */





}
