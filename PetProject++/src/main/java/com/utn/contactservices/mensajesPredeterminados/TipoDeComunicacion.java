package com.utn.contactservices.mensajesPredeterminados;

import com.utn.models.User;
import java.util.*;
public class TipoDeComunicacion {
    public static String asunto(IMensajePredet situacion) {
        return situacion.asunto();  
    }

    //Construir bien los mensajes con datos de formularios y publicaciones
    public static String cuerpo(IMensajePredet situacion) {
        String inputDeUsuario;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Redacte su mensaje para el dueño de la mascota\t: ");
        inputDeUsuario = scanner.nextLine();
        scanner.close();
        return situacion.mensajePredet(inputDeUsuario);        
    }

    public static String obtenerDatosInteresado(User usuario){
        //OBTENER DATOS NECESARIOS Y ARMAR MAIL
        return "aaa";
    }
}