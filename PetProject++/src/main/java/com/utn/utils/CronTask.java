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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CronTask {
    FormController controller = new FormController(new FormService(new FormRepo()));

    @Scheduled(initialDelay = 10000, fixedDelay = 2000) // 1 semana = 604800000
    public void timer(){
        System.out.println("PRUEBA PRUEBA\n");
    }

    public void activarChromeTask() throws IOException {
        Iterable<FormularioIntencionAdopcion> formulariosIntencionAdoptar = controller.GetFormsIntencionAdopcion();
        List<FormularioDarEnAdopcion> formulariosDarEnAdopcion = new ArrayList<>();
        controller.GetFormsDarEnAdopcion().forEach(formulariosDarEnAdopcion::add);
        //Iterable<FormularioDarEnAdopcion> formulariosDarEnAdopcion = controller.GetFormsDarEnAdopcion();


        for(FormularioIntencionAdopcion formulario: formulariosIntencionAdoptar){
            Iterable<FormularioDarEnAdopcion> formulariosAceptados;
            formulariosAceptados = formulariosDarEnAdopcion.stream().filter(formularioDarEnAdopcion -> this.cumpleCaracteristicas(formulario, formularioDarEnAdopcion)).collect(Collectors.toList());

            String sugerencias = null;

            //TODO forEach pasarAString(formularios)

            if(sugerencias != null){
                CSugerenciasAdopcion msg = new CSugerenciasAdopcion(sugerencias);
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
