package com.utn.contactservices.mensajesPredeterminados;

import com.utn.models.User;
import java.util.*;
public class TipoDeComunicacion {
    public static String asunto(String situacion) {
        switch (situacion) {
            case "M-QREscaneado":
                return "QR de mascota escaneado";

            case "M-MascotaReconocida":
                return "Mascota reconocida por el dueño";

            case "M-InteresDeAdopcion":
                return "Hay alguien interesado en adoptar tu mascota";

            case "M-SugerenciasAdopcion":
                return "Buscando una mascota? Te traemos algunas sugerencias";

            default:
                return " ";
        }
    }

    public static String cuerpo(String situacion) {
        String cuerpoDeMensaje;
        String inputDeUsuario;
        Scanner scanner = new Scanner(System.in);

        switch (situacion) {
            case "M-MascotaReconocida":
                System.out.print("Redacte su mensaje para el rescatista: \t ");
                inputDeUsuario = scanner.nextLine();
                cuerpoDeMensaje = "Mascota reconocida por el dueño \t " + inputDeUsuario;
                scanner.close();
                return cuerpoDeMensaje;

            default:
                inputDeUsuario = scanner.nextLine();
                scanner.close();
                return inputDeUsuario;
        }
    };
    //Construir bien los mensajes con datos de formularios y publicaciones
    public static String cuerpo(String mensajeDeUsuario, IMensajePredet situacion) {
        String inputDeUsuario;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Redacte su mensaje para el dueño de la mascota\t: ");
        inputDeUsuario = scanner.nextLine();
        scanner.close();
        return situacion.mensajePredet(inputDeUsuario);

          /*  case "M-InteresDeAdopcion":
                System.out.print("Redacte su mensaje para el dueño de la mascota\t: ");
                inputDeUsuario = scanner.nextLine();
                String datosInteresado = TipoDeComunicacion.obtenerDatosInteresado(usuario);
                scanner.close();
                cuerpoDeMensaje = "Un usuario ha mostrado interés en adoptar su mascota \t " + inputDeUsuario + datosInteresado;
                return cuerpoDeMensaje;

            case "M-SugerenciasAdopcion":
                scanner.close();
                return /*this.armarListaSugerencias(usuario)*/
        
    }

    public static String obtenerDatosInteresado(User usuario){
        //OBTENER DATOS NECESARIOS Y ARMAR MAIL
        return "aaa";
    }
}