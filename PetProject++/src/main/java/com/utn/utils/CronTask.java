package com.utn.utils;

import com.utn.contactservices.mensajesPredeterminados.CSugerenciasAdopcion;
import com.utn.controllers.FormController;
import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioIntencionAdopcion;
import com.utn.models.mascotas.CaracteristicaPet;
import com.utn.models.mascotas.Mascota;
import com.utn.models.users.Comodidaes.Comodidad;
import com.utn.models.users.Usuario;
import com.utn.repositories.FormRepo;
import com.utn.services.FormService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CronTask {
    FormController controller = new FormController(new FormService(new FormRepo()));

    public void activarChromeTask() throws IOException {
        Iterable<FormularioIntencionAdopcion> formulariosIntencionAdoptar = controller.GetFormsIntencionAdopcion();
        List<FormularioDarEnAdopcion> formulariosDarEnAdopcion = new ArrayList<>();
        controller.GetFormsDarEnAdopcion().forEach(formulariosDarEnAdopcion::add);
        //Iterable<FormularioDarEnAdopcion> formulariosDarEnAdopcion = controller.GetFormsDarEnAdopcion();


        for(FormularioIntencionAdopcion formulario: formulariosIntencionAdoptar){
            Iterable<FormularioDarEnAdopcion> formulariosAceptados;
            formulariosAceptados = formulariosDarEnAdopcion.stream().filter(formularioDarEnAdopcion -> this.cumpleCaracteristicas(formulario, formularioDarEnAdopcion)).collect(Collectors.toList());

            String sugerencias = null;
            for(FormularioDarEnAdopcion unFormulario : formulariosAceptados){
                sugerencias = unFormulario.agregarAListaDeSugerencias(sugerencias);
            }

            if(sugerencias != null){
                CSugerenciasAdopcion msg = new CSugerenciasAdopcion(sugerencias);
                formulario.getSolicitante().contactar(msg);
            }else{
                String mensaje = "El sistema no encontró sugerencias de acuerdo a lo que buscabas, puedes esperar o llenar otro formulario para que te podamos ayudar a encontrar una mascota";
                CSugerenciasAdopcion msg = new CSugerenciasAdopcion(mensaje);
                formulario.getSolicitante().contactar(msg);
            }
        }
    }

    public boolean cumpleCaracteristicas(FormularioIntencionAdopcion formularioIntencionAdoptar, FormularioDarEnAdopcion formularioDarEnAdopcion){

        Mascota mascota = formularioDarEnAdopcion.getMascota();
        Usuario usuarioIntencionAdoptar = formularioIntencionAdoptar.getSolicitante();

        if(formularioIntencionAdoptar.getEspecie() != mascota.getEspecie()){
            return false;
        }
        if(formularioIntencionAdoptar.getSexo() != mascota.getSexo()){
            return false;
        }

        for(CaracteristicaPet preferencia: formularioIntencionAdoptar.getPreferencias()){
            CaracteristicaPet caracteristica = mascota.getCaracteristicSet().stream().
                    filter(caract ->
                            caract.getTipoCaracteristica().getDescripcion() == preferencia.getTipoCaracteristica().getDescripcion()
                    ).
                    findFirst().orElse(null);

            if(caracteristica == null || preferencia.getvalor() != caracteristica.getvalor()){
                return false;
            }

            for(Comodidad comodidad: usuarioIntencionAdoptar.getComodidades()){
                if(!comodidad.cumpleComodidad(formularioDarEnAdopcion)){
                    return false;
                }
            }
        }

        return true;
    }

}
