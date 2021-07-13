package com.utn.contactservices;

public class SMS {
    public static void contactar(String destinatario, String asunto, String cuerpo) {
        Vonage.enviarMensaje(destinatario,cuerpo);
    }
}
